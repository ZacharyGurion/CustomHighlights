package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class DartKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "while", "do",
            "switch", "case", "default",
            "break", "continue", "return",
            "throw", "rethrow", "try", "catch", "on", "finally",
            "yield", "await"
        ) to CustomHighlightsColors.DART.controlFlow,

        setOf(
            "var", "final", "const", "late",
            "void", "dynamic"
        ) to CustomHighlightsColors.DART.literalType,

        setOf("null") to CustomHighlightsColors.DART.nullLiteral,
        setOf("true") to CustomHighlightsColors.DART.trueLiteral,
        setOf("false") to CustomHighlightsColors.DART.falseLiteral,

        setOf("+", "-", "*", "/", "%", "~/") to CustomHighlightsColors.DART.arithmetic,
        setOf("&&", "||", "!") to CustomHighlightsColors.DART.logical,
        setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.DART.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "??=") to CustomHighlightsColors.DART.assignment,
    )
    // `<`/`>` appear in generic type parameters (List<String>, Map<K, V>)
    override val expressionOnlyOperators = setOf("<", ">")
}
