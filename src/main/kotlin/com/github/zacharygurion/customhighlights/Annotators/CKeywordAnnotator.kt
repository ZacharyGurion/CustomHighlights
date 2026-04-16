package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class CKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "while", "do",
            "switch", "case", "default",
            "break", "continue", "return", "goto"
        ) to CustomHighlightsColors.C.controlFlow,

        setOf(
            "void",
            "int", "long", "short", "char",
            "float", "double",
            "unsigned", "signed",
            "bool", "_Bool"
        ) to CustomHighlightsColors.C.literalType,

        setOf("NULL") to CustomHighlightsColors.C.nullLiteral,
        setOf("true") to CustomHighlightsColors.C.trueLiteral,
        setOf("false") to CustomHighlightsColors.C.falseLiteral,

        setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.C.arithmetic,
        setOf("&&", "||", "!") to CustomHighlightsColors.C.logical,
        setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.C.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=") to CustomHighlightsColors.C.assignment,
    )
    // `*` appears in pointer type declarations (int *p) and pointer dereferences used as types
    override val expressionOnlyOperators = setOf("*")
}