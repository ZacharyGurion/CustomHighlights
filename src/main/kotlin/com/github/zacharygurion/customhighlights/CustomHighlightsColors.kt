package com.github.zacharygurion.customhighlights

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import java.awt.Color

/**
 * Per-language color keys, each falling back to the corresponding global key.
 * Users can override individual languages in Settings > Editor > Color Scheme > Custom Highlights
 * under "Language Overrides". Setting a key to inherit from a language's own default color
 * effectively disables that category for that language.
 */
class LanguageColors(prefix: String) {
    val controlFlow = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_CONTROL_FLOW", CustomHighlightsColors.CONTROL_FLOW_KEYWORD)
    val literalType = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_LITERAL_TYPE", CustomHighlightsColors.LITERAL_TYPE)
    val access      = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_ACCESS",        CustomHighlightsColors.ACCESS_KEYWORD)
    val nullLiteral = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_NULL",          CustomHighlightsColors.NULL_LITERAL)
    val trueLiteral = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_TRUE",          CustomHighlightsColors.TRUE_LITERAL)
    val falseLiteral= TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_FALSE",         CustomHighlightsColors.FALSE_LITERAL)
    val arithmetic  = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_ARITHMETIC",    CustomHighlightsColors.ARITHMETIC_OPERATOR)
    val logical     = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_LOGICAL",       CustomHighlightsColors.LOGICAL_OPERATOR)
    val comparison  = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_COMPARISON",    CustomHighlightsColors.COMPARISON_OPERATOR)
    val assignment  = TextAttributesKey.createTextAttributesKey("CUSTOMHIGHLIGHTS_${prefix}_ASSIGNMENT",    CustomHighlightsColors.ASSIGNMENT_OPERATOR)
}


object CustomHighlightsColors {
    // Default colors match LoamStone's palette. Color schemes (including LoamStone's bundled
    // scheme) can override these via CUSTOMHIGHLIGHTS_* entries in their color scheme XML.

    // Keywords
    val CONTROL_FLOW_KEYWORD: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_CONTROL_FLOW_KEYWORD",
        TextAttributes(Color(0xEA6962), null, null, null, 0)
    )
    val LITERAL_TYPE: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_LITERAL_TYPE",
        TextAttributes(Color(0xE78A4E), null, null, null, 0)
    )
    val ACCESS_KEYWORD: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_ACCESS_KEYWORD",
        TextAttributes(Color(0x7DAEA3), null, null, null, 0)
    )

    // Literals — null/nil: amber, true: yellow-green, false: red
    val NULL_LITERAL: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_NULL_LITERAL",
        TextAttributes(Color(0xD8A657), null, null, null, 0)
    )
    val TRUE_LITERAL: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_TRUE_LITERAL",
        TextAttributes(Color(0xA9B665), null, null, null, 0)
    )
    val FALSE_LITERAL: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_FALSE_LITERAL",
        TextAttributes(Color(0xEA6962), null, null, null, 0)
    )

    // Operators — each category inherits from the language's default operation-sign color
    val ARITHMETIC_OPERATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_ARITHMETIC_OPERATOR",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val LOGICAL_OPERATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_LOGICAL_OPERATOR",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val COMPARISON_OPERATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_COMPARISON_OPERATOR",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val ASSIGNMENT_OPERATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "CUSTOMHIGHLIGHTS_ASSIGNMENT_OPERATOR",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )

    // Per-language overrides — each key falls back to the global above
    val C      = LanguageColors("C")
    val CSHARP = LanguageColors("CSHARP")
    val CPP    = LanguageColors("CPP")
    val DART   = LanguageColors("DART")
    val GO     = LanguageColors("GO")
    val GROOVY = LanguageColors("GROOVY")
    val JAVA   = LanguageColors("JAVA")
    val JS     = LanguageColors("JS")
    val KOTLIN = LanguageColors("KOTLIN")
    val PHP    = LanguageColors("PHP")
    val PYTHON = LanguageColors("PYTHON")
    val RUBY   = LanguageColors("RUBY")
    val RUST   = LanguageColors("RUST")
    val SCALA  = LanguageColors("SCALA")
    val SQL    = LanguageColors("SQL")
    val TS     = LanguageColors("TS")
}
