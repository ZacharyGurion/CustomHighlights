package com.github.zacharygurion.customhighlights.Annotators

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

/**
 * Text-based keyword annotator for languages where we classify by exact keyword text.
 *
 * Matches any [LeafPsiElement] whose text is an exact entry in one of the [categories] sets.
 * To add a new language: subclass this, declare [categories], and register an annotator
 * extension in plugin.xml (or an optional config file if the language plugin isn't always present).
 */
abstract class LeafTextKeywordAnnotator : CustomKeywordAnnotator() {

    protected abstract val categories: List<Pair<Set<String>, TextAttributesKey>>

    /** Override to false for case-insensitive languages (e.g. SQL). Categories should then use uppercase strings. */
    protected open val caseSensitive: Boolean = true

    /**
     * Operator texts that should only be highlighted when the leaf sits inside an expression
     * node (parent class name contains "Expression", "Binary", "Conditional", or "Unary").
     *
     * Use this to prevent characters like `<`, `>`, and `*` from being colored as operators
     * when they appear in non-operator positions: generic type parameters, pointer type
     * declarations, import wildcards, class-inheritance clauses, JSX tags, etc.
     */
    protected open val expressionOnlyOperators: Set<String> = emptySet()

    private fun isInExpressionContext(element: LeafPsiElement): Boolean {
        val parentName = element.parent?.javaClass?.simpleName ?: return false
        return parentName.contains("Expression") || parentName.contains("Binary") ||
            parentName.contains("Conditional") || parentName.contains("Unary")
    }

    override fun classify(element: PsiElement): TextAttributesKey? {
        if (element !is LeafPsiElement) return null
        // Skip expression-sensitive operators that are not in an expression context
        if (element.text in expressionOnlyOperators && !isInExpressionContext(element)) return null
        val text = if (caseSensitive) element.text else element.text.uppercase()
        return categories.firstOrNull { text in it.first }?.second
    }
}
