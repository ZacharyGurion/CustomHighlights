package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class CSharpKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "foreach", "while", "do",
            "switch", "case", "default",
            "break", "continue", "return", "goto",
            "throw", "try", "catch", "finally",
            "yield", "await"
        ) to CustomHighlightsColors.CSHARP.controlFlow,

        setOf(
            "void",
            "int", "long", "short", "byte",
            "double", "float", "decimal",
            "bool", "char", "string", "object",
            "uint", "ulong", "ushort", "sbyte",
            "var", "dynamic"
        ) to CustomHighlightsColors.CSHARP.literalType,

        setOf("public", "private", "protected", "internal") to CustomHighlightsColors.CSHARP.access,

        setOf("null") to CustomHighlightsColors.CSHARP.nullLiteral,
        setOf("true") to CustomHighlightsColors.CSHARP.trueLiteral,
        setOf("false") to CustomHighlightsColors.CSHARP.falseLiteral,

        setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.CSHARP.arithmetic,
        setOf("&&", "||", "!") to CustomHighlightsColors.CSHARP.logical,
        setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.CSHARP.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=") to CustomHighlightsColors.CSHARP.assignment,
    )
    // `<`/`>` appear in generic type parameters (List<T>, Dictionary<K,V>)
    override val expressionOnlyOperators = setOf("<", ">")
}
