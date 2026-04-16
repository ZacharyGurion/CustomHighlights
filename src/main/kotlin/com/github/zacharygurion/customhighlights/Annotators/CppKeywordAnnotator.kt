package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class CppKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "while", "do",
            "switch", "case", "default",
            "break", "continue", "return", "goto",
            "throw", "try", "catch"
        ) to CustomHighlightsColors.CPP.controlFlow,

        setOf(
            "void",
            "int", "long", "short", "char",
            "float", "double",
            "unsigned", "signed",
            "bool", "wchar_t", "char16_t", "char32_t", "char8_t",
            "auto"
        ) to CustomHighlightsColors.CPP.literalType,

        setOf("public", "private", "protected") to CustomHighlightsColors.CPP.access,

        setOf("NULL", "nullptr") to CustomHighlightsColors.CPP.nullLiteral,
        setOf("true") to CustomHighlightsColors.CPP.trueLiteral,
        setOf("false") to CustomHighlightsColors.CPP.falseLiteral,

        setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.CPP.arithmetic,
        setOf("&&", "||", "!") to CustomHighlightsColors.CPP.logical,
        setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.CPP.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=") to CustomHighlightsColors.CPP.assignment,
    )
    // `*` appears in pointer type declarations; `<`/`>` appear in template parameters
    override val expressionOnlyOperators = setOf("<", ">", "*")
}
