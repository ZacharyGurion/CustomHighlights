package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

private val PHP_CATEGORIES: List<Pair<Set<String>, TextAttributesKey>> = listOf(
    setOf(
        "if", "else", "elseif",
        "for", "foreach", "while", "do",
        "switch", "case", "default",
        "break", "continue", "return",
        "throw", "try", "catch", "finally",
        "match", "yield", "goto"
    ) to CustomHighlightsColors.PHP.controlFlow,

    setOf(
        "function", "class", "interface", "trait", "enum",
        "void", "int", "string", "bool", "float",
        "array", "callable", "iterable", "mixed", "never", "object"
    ) to CustomHighlightsColors.PHP.literalType,

    setOf("public", "private", "protected") to CustomHighlightsColors.PHP.access,

    // PHP keywords are case-insensitive but null/true/false are conventionally lowercase
    setOf("NULL") to CustomHighlightsColors.PHP.nullLiteral,
    setOf("TRUE") to CustomHighlightsColors.PHP.trueLiteral,
    setOf("FALSE") to CustomHighlightsColors.PHP.falseLiteral,

    setOf("+", "-", "*", "/", "%", "**") to CustomHighlightsColors.PHP.arithmetic,
    setOf("&&", "||", "!", "and", "or", "not") to CustomHighlightsColors.PHP.logical,
    setOf("==", "!=", "===", "!==", "<", ">", "<=", ">=", "<>", "<=>") to CustomHighlightsColors.PHP.comparison,
    setOf("=", "+=", "-=", "*=", "/=", "%=", "**=", "&=", "|=", "^=", ".=") to CustomHighlightsColors.PHP.assignment,
)

class PhpKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories = PHP_CATEGORIES
    override val caseSensitive = false
}
