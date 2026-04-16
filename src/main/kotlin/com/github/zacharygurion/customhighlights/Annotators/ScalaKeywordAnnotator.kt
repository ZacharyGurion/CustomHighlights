package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

private val SCALA_CATEGORIES: List<Pair<Set<String>, TextAttributesKey>> = listOf(
    setOf(
        "if", "else",
        "for", "while", "do",
        "match", "case",
        "return", "throw",
        "try", "catch", "finally",
        "yield"
    ) to CustomHighlightsColors.SCALA.controlFlow,

    setOf(
        "val", "var", "def", "type",
        "class", "object", "trait"
    ) to CustomHighlightsColors.SCALA.literalType,

    setOf("public", "private", "protected") to CustomHighlightsColors.SCALA.access,

    setOf("null") to CustomHighlightsColors.SCALA.nullLiteral,
    setOf("true") to CustomHighlightsColors.SCALA.trueLiteral,
    setOf("false") to CustomHighlightsColors.SCALA.falseLiteral,

    setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.SCALA.arithmetic,
    setOf("&&", "||", "!") to CustomHighlightsColors.SCALA.logical,
    setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.SCALA.comparison,
    setOf("=", "+=", "-=", "*=", "/=", "%=") to CustomHighlightsColors.SCALA.assignment,
)

class ScalaKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories = SCALA_CATEGORIES
    // `<`/`>` appear in generic type parameters
    override val expressionOnlyOperators = setOf("<", ">")
}
