package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class RustKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "else",
            "for", "while", "loop",
            "match",
            "break", "continue", "return"
        ) to CustomHighlightsColors.RUST.controlFlow,

        setOf(
            "fn", "let", "mut",
            "type", "struct", "enum", "impl", "trait", "union",
            "const", "static", "ref", "dyn"
        ) to CustomHighlightsColors.RUST.literalType,

        setOf("pub") to CustomHighlightsColors.RUST.access,

        setOf("true") to CustomHighlightsColors.RUST.trueLiteral,
        setOf("false") to CustomHighlightsColors.RUST.falseLiteral,
        // Rust has no null literal; None is an enum variant, not a built-in literal

        setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.RUST.arithmetic,
        setOf("&&", "||", "!") to CustomHighlightsColors.RUST.logical,
        setOf("==", "!=", "<", ">", "<=", ">=") to CustomHighlightsColors.RUST.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=") to CustomHighlightsColors.RUST.assignment,
    )
}
