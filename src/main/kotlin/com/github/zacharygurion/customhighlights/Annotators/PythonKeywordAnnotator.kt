package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class PythonKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "elif", "else",
            "for", "while",
            "break", "continue", "return", "yield",
            "try", "except", "finally", "raise",
            "with", "match", "case",
            "async", "await"
        ) to CustomHighlightsColors.PYTHON.controlFlow,

        setOf(
            "def", "class", "lambda"
        ) to CustomHighlightsColors.PYTHON.literalType,

        setOf("None") to CustomHighlightsColors.PYTHON.nullLiteral,
        setOf("True") to CustomHighlightsColors.PYTHON.trueLiteral,
        setOf("False") to CustomHighlightsColors.PYTHON.falseLiteral,

        setOf("+", "-", "*", "/", "%", "**", "//") to CustomHighlightsColors.PYTHON.arithmetic,
        setOf("and", "or", "not") to CustomHighlightsColors.PYTHON.logical,
        setOf("==", "!=", "<", ">", "<=", ">=", "is", "in") to CustomHighlightsColors.PYTHON.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "**=", "//=", "&=", "|=", "^=", ":=") to CustomHighlightsColors.PYTHON.assignment,
    )
}
