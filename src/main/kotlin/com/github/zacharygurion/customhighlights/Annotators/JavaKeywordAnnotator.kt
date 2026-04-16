package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

private val JAVA_CATEGORIES: List<Pair<Set<String>, TextAttributesKey>> = listOf(
    setOf(
        "if", "else",
        "for", "while", "do",
        "switch", "case", "default",
        "break", "continue", "return",
        "throw", "try", "catch", "finally",
        "assert", "yield"
    ) to CustomHighlightsColors.JAVA.controlFlow,

    setOf(
        "void",
        "int", "long", "short", "byte",
        "double", "float",
        "boolean", "char"
    ) to CustomHighlightsColors.JAVA.literalType,

    setOf(
        "public", "private", "protected"
    ) to CustomHighlightsColors.JAVA.access,

    setOf("null") to CustomHighlightsColors.JAVA.nullLiteral,
    setOf("true") to CustomHighlightsColors.JAVA.trueLiteral,
    setOf("false") to CustomHighlightsColors.JAVA.falseLiteral,

    setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.JAVA.arithmetic,
    setOf("&&", "||", "!") to CustomHighlightsColors.JAVA.logical,
    setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.JAVA.comparison,
    setOf("=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=", ">>>=") to CustomHighlightsColors.JAVA.assignment,
)

class JavaKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories = JAVA_CATEGORIES
    // `<`/`>` appear in generic type parameters; `*` appears in import wildcards
    override val expressionOnlyOperators = setOf("<", ">", "*")
}
