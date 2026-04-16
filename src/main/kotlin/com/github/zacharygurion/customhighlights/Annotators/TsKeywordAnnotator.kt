package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class TsKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "while", "do",
            "switch", "case", "default",
            "break", "continue", "return",
            "throw", "try", "catch", "finally",
            "yield", "await"
        ) to CustomHighlightsColors.TS.controlFlow,

        setOf(
            "var", "let", "const",
            "function", "class",
            "async",
            "type", "interface", "enum", "namespace"
        ) to CustomHighlightsColors.TS.literalType,

        setOf(
            "public", "private", "protected",
            "readonly", "abstract", "override", "declare"
        ) to CustomHighlightsColors.TS.access,

        setOf("null", "undefined") to CustomHighlightsColors.TS.nullLiteral,
        setOf("true") to CustomHighlightsColors.TS.trueLiteral,
        setOf("false") to CustomHighlightsColors.TS.falseLiteral,

        setOf("+", "-", "*", "/", "%", "**") to CustomHighlightsColors.TS.arithmetic,
        setOf("&&", "||", "!", "??") to CustomHighlightsColors.TS.logical,
        setOf("==", "!=", "===", "!==", "<", ">", "<=", ">=") to CustomHighlightsColors.TS.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "**=", "&=", "|=", "^=", "&&=", "||=", "??=") to CustomHighlightsColors.TS.assignment,
    )
    // `<`/`>` appear in generic type parameters and JSX tags
    override val expressionOnlyOperators = setOf("<", ">")
}
