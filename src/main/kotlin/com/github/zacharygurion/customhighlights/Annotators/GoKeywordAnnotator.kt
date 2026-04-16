package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class GoKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "switch", "select",
            "case", "default",
            "break", "continue", "return", "goto", "fallthrough"
        ) to CustomHighlightsColors.GO.controlFlow,

        setOf(
            "var", "const",
            "func", "type",
            "chan", "map", "interface", "struct"
        ) to CustomHighlightsColors.GO.literalType,

        setOf("nil") to CustomHighlightsColors.GO.nullLiteral,
        setOf("true") to CustomHighlightsColors.GO.trueLiteral,
        setOf("false") to CustomHighlightsColors.GO.falseLiteral,

        setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.GO.arithmetic,
        setOf("&&", "||", "!") to CustomHighlightsColors.GO.logical,
        setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.GO.comparison,
        setOf("=", ":=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=") to CustomHighlightsColors.GO.assignment,
    )
    // `*` appears in pointer type declarations (var p *int) and pointer receiver declarations
    override val expressionOnlyOperators = setOf("*")
}
