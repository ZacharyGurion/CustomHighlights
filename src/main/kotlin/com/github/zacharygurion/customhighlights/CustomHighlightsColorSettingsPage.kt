package com.github.zacharygurion.customhighlights

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainTextLanguage
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class CustomHighlightsColorSettingsPage : ColorSettingsPage {

    private companion object {

        fun langDescriptors(name: String, lc: LanguageColors) = listOf(
            AttributesDescriptor("Language Overrides//$name//Keyword//Control Flow",      lc.controlFlow),
            AttributesDescriptor("Language Overrides//$name//Keyword//Access / Visibility", lc.access),
            AttributesDescriptor("Language Overrides//$name//Literal//Type",               lc.literalType),
            AttributesDescriptor("Language Overrides//$name//Literal//Null / Nil / Undefined", lc.nullLiteral),
            AttributesDescriptor("Language Overrides//$name//Literal//True",               lc.trueLiteral),
            AttributesDescriptor("Language Overrides//$name//Literal//False",              lc.falseLiteral),
            AttributesDescriptor("Language Overrides//$name//Operator//Arithmetic",        lc.arithmetic),
            AttributesDescriptor("Language Overrides//$name//Operator//Logical",           lc.logical),
            AttributesDescriptor("Language Overrides//$name//Operator//Comparison",        lc.comparison),
            AttributesDescriptor("Language Overrides//$name//Operator//Assignment",        lc.assignment),
        )

        val DESCRIPTORS: Array<AttributesDescriptor> = (listOf(
            // Global defaults
            AttributesDescriptor("Keyword//Control Flow",            CustomHighlightsColors.CONTROL_FLOW_KEYWORD),
            AttributesDescriptor("Keyword//Access / Visibility",     CustomHighlightsColors.ACCESS_KEYWORD),
            AttributesDescriptor("Literal//Type",                    CustomHighlightsColors.LITERAL_TYPE),
            AttributesDescriptor("Literal//Null / Nil / Undefined",  CustomHighlightsColors.NULL_LITERAL),
            AttributesDescriptor("Literal//Boolean//True",           CustomHighlightsColors.TRUE_LITERAL),
            AttributesDescriptor("Literal//Boolean//False",          CustomHighlightsColors.FALSE_LITERAL),
            AttributesDescriptor("Operator//Arithmetic",             CustomHighlightsColors.ARITHMETIC_OPERATOR),
            AttributesDescriptor("Operator//Logical",                CustomHighlightsColors.LOGICAL_OPERATOR),
            AttributesDescriptor("Operator//Comparison",             CustomHighlightsColors.COMPARISON_OPERATOR),
            AttributesDescriptor("Operator//Assignment",             CustomHighlightsColors.ASSIGNMENT_OPERATOR),
        ) + langDescriptors("C",          CustomHighlightsColors.C)
          + langDescriptors("C#",         CustomHighlightsColors.CSHARP)
          + langDescriptors("C++",        CustomHighlightsColors.CPP)
          + langDescriptors("Dart",       CustomHighlightsColors.DART)
          + langDescriptors("Go",         CustomHighlightsColors.GO)
          + langDescriptors("Groovy",     CustomHighlightsColors.GROOVY)
          + langDescriptors("Java",       CustomHighlightsColors.JAVA)
          + langDescriptors("JavaScript", CustomHighlightsColors.JS)
          + langDescriptors("Kotlin",     CustomHighlightsColors.KOTLIN)
          + langDescriptors("PHP",        CustomHighlightsColors.PHP)
          + langDescriptors("Python",     CustomHighlightsColors.PYTHON)
          + langDescriptors("Ruby",       CustomHighlightsColors.RUBY)
          + langDescriptors("Rust",       CustomHighlightsColors.RUST)
          + langDescriptors("Scala",      CustomHighlightsColors.SCALA)
          + langDescriptors("SQL",        CustomHighlightsColors.SQL)
          + langDescriptors("TypeScript", CustomHighlightsColors.TS)
        ).toTypedArray()

        val TAG_MAP: Map<String, TextAttributesKey> = mapOf(
            "cf" to CustomHighlightsColors.CONTROL_FLOW_KEYWORD,
            "ty" to CustomHighlightsColors.LITERAL_TYPE,
            "ac" to CustomHighlightsColors.ACCESS_KEYWORD,
            "nl" to CustomHighlightsColors.NULL_LITERAL,
            "tr" to CustomHighlightsColors.TRUE_LITERAL,
            "fa" to CustomHighlightsColors.FALSE_LITERAL,
            "ar" to CustomHighlightsColors.ARITHMETIC_OPERATOR,
            "lo" to CustomHighlightsColors.LOGICAL_OPERATOR,
            "co" to CustomHighlightsColors.COMPARISON_OPERATOR,
            "as" to CustomHighlightsColors.ASSIGNMENT_OPERATOR,
        )
    }

    override fun getDisplayName(): String = "Custom Highlights"
    override fun getIcon(): Icon? = null
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS

    override fun getHighlighter(): SyntaxHighlighter =
        SyntaxHighlighterFactory.getSyntaxHighlighter(PlainTextLanguage.INSTANCE, null, null)
            ?: object : SyntaxHighlighterBase() {
                override fun getHighlightingLexer() = com.intellij.lexer.EmptyLexer()
                override fun getTokenHighlights(tokenType: IElementType) = emptyArray<TextAttributesKey>()
            }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> = TAG_MAP

    override fun getDemoText(): String = """
        // Keywords
        <cf>if</cf> (x <co>></co> 0) { <cf>return</cf> x; } <cf>else</cf> { <cf>throw</cf> new Error(); }
        <cf>for</cf> (i <as>=</as> 0; i <co><</co> n; i<as>++</as>) { }
        <ty>void</ty> process(<ty>int</ty> count) { }
        <ac>public</ac> <ty>class</ty> MyClass { <ac>private</ac> <ty>int</ty> value; }

        // Literals
        <ty>var</ty> a <as>=</as> <tr>true</tr>;
        <ty>var</ty> b <as>=</as> <fa>false</fa>;
        <ty>var</ty> c <as>=</as> <nl>null</nl>;

        // Operators
        result <as>=</as> x <ar>+</ar> y <ar>*</ar> z;
        <cf>if</cf> (a <co>==</co> b <lo>&&</lo> <lo>!</lo>c) { }
        x <as>+=</as> 1;
    """.trimIndent()
}
