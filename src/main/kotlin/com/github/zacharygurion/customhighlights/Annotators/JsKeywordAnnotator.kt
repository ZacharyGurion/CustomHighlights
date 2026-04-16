package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class JsKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "while", "do",
            "switch", "case", "default",
            "break", "continue", "return",
            "throw", "try", "catch", "finally",
            "yield", "await"
        ) to CustomHighlightsColors.JS.controlFlow,

        setOf(
            "var", "let", "const",
            "function", "class",
            "async"
        ) to CustomHighlightsColors.JS.literalType,

        setOf("null", "undefined") to CustomHighlightsColors.JS.nullLiteral,
        setOf("true") to CustomHighlightsColors.JS.trueLiteral,
        setOf("false") to CustomHighlightsColors.JS.falseLiteral,

        setOf("+", "-", "*", "/", "%", "**") to CustomHighlightsColors.JS.arithmetic,
        setOf("&&", "||", "!", "??") to CustomHighlightsColors.JS.logical,
        setOf("==", "!=", "===", "!==", "<", ">", "<=", ">=") to CustomHighlightsColors.JS.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "**=", "&=", "|=", "^=", "&&=", "||=", "??=") to CustomHighlightsColors.JS.assignment,
    )
    // `<`/`>` appear in JSX tags (<div>, </div>) and TypeScript-style generics in .js files
    override val expressionOnlyOperators = setOf("<", ">")
}
