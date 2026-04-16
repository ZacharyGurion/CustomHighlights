package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

private val GROOVY_CATEGORIES: List<Pair<Set<String>, TextAttributesKey>> = listOf(
    setOf(
        "if", "else",
        "for", "while", "do",
        "switch", "case", "default",
        "break", "continue", "return",
        "throw", "try", "catch", "finally",
        "assert", "in"
    ) to CustomHighlightsColors.GROOVY.controlFlow,

    setOf(
        "def", "var",
        "void",
        "int", "long", "short", "byte",
        "double", "float",
        "boolean", "char"
    ) to CustomHighlightsColors.GROOVY.literalType,

    setOf("public", "private", "protected") to CustomHighlightsColors.GROOVY.access,

    setOf("null") to CustomHighlightsColors.GROOVY.nullLiteral,
    setOf("true") to CustomHighlightsColors.GROOVY.trueLiteral,
    setOf("false") to CustomHighlightsColors.GROOVY.falseLiteral,

    setOf("+", "-", "*", "/", "%", "**") to CustomHighlightsColors.GROOVY.arithmetic,
    setOf("&&", "||", "!") to CustomHighlightsColors.GROOVY.logical,
    setOf("==", "!=", "<", ">", "<=", ">=", "<=>", "===") to CustomHighlightsColors.GROOVY.comparison,
    setOf("=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=") to CustomHighlightsColors.GROOVY.assignment,
)

class GroovyKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories = GROOVY_CATEGORIES
    // `<`/`>` appear in generic type parameters
    override val expressionOnlyOperators = setOf("<", ">")
}
