package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

class RubyKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories: List<Pair<Set<String>, TextAttributesKey>> = listOf(
        setOf(
            "if", "elsif", "else", "unless", "then",
            "case", "when", "in",
            "for", "while", "until", "do",
            "break", "next", "return", "raise",
            "retry", "redo",
            "begin", "rescue", "ensure", "end",
            "yield"
        ) to CustomHighlightsColors.RUBY.controlFlow,

        setOf(
            "def", "class", "module"
        ) to CustomHighlightsColors.RUBY.literalType,

        setOf("public", "private", "protected") to CustomHighlightsColors.RUBY.access,

        setOf("nil") to CustomHighlightsColors.RUBY.nullLiteral,
        setOf("true") to CustomHighlightsColors.RUBY.trueLiteral,
        setOf("false") to CustomHighlightsColors.RUBY.falseLiteral,

        setOf("+", "-", "*", "/", "%", "**") to CustomHighlightsColors.RUBY.arithmetic,
        setOf("&&", "||", "!", "and", "or", "not") to CustomHighlightsColors.RUBY.logical,
        setOf("==", "!=", "<", ">", "<=", ">=", "<=>", "===") to CustomHighlightsColors.RUBY.comparison,
        setOf("=", "+=", "-=", "*=", "/=", "%=", "**=", "&=", "|=", "^=") to CustomHighlightsColors.RUBY.assignment,
    )

    // `<` appears in class inheritance clauses (class Dog < Animal)
    override val expressionOnlyOperators = setOf("<", ">")
}
