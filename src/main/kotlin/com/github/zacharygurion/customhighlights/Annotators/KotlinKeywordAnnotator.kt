package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.lexer.KtTokens

private val KOTLIN_CATEGORIES = listOf(
    setOf(
        KtTokens.IF_KEYWORD, KtTokens.ELSE_KEYWORD,
        KtTokens.FOR_KEYWORD, KtTokens.WHILE_KEYWORD, KtTokens.DO_KEYWORD,
        KtTokens.WHEN_KEYWORD,
        KtTokens.BREAK_KEYWORD, KtTokens.CONTINUE_KEYWORD, KtTokens.RETURN_KEYWORD,
        KtTokens.THROW_KEYWORD,
        KtTokens.TRY_KEYWORD, KtTokens.CATCH_KEYWORD, KtTokens.FINALLY_KEYWORD
    ) to CustomHighlightsColors.KOTLIN.controlFlow,

    setOf(
        KtTokens.VAL_KEYWORD, KtTokens.VAR_KEYWORD, KtTokens.FUN_KEYWORD
    ) to CustomHighlightsColors.KOTLIN.literalType,

    setOf(
        KtTokens.PUBLIC_KEYWORD, KtTokens.PRIVATE_KEYWORD,
        KtTokens.PROTECTED_KEYWORD, KtTokens.INTERNAL_KEYWORD
    ) to CustomHighlightsColors.KOTLIN.access,

    setOf(KtTokens.NULL_KEYWORD) to CustomHighlightsColors.KOTLIN.nullLiteral,
    setOf(KtTokens.TRUE_KEYWORD) to CustomHighlightsColors.KOTLIN.trueLiteral,
    setOf(KtTokens.FALSE_KEYWORD) to CustomHighlightsColors.KOTLIN.falseLiteral,

    setOf(KtTokens.PLUS, KtTokens.MINUS, KtTokens.MUL, KtTokens.DIV, KtTokens.PERC) to CustomHighlightsColors.KOTLIN.arithmetic,
    setOf(KtTokens.ANDAND, KtTokens.OROR, KtTokens.EXCL) to CustomHighlightsColors.KOTLIN.logical,
    setOf(KtTokens.EQEQ, KtTokens.EXCLEQ, KtTokens.LT, KtTokens.GT, KtTokens.LTEQ, KtTokens.GTEQ) to CustomHighlightsColors.KOTLIN.comparison,
    setOf(KtTokens.EQ, KtTokens.PLUSEQ, KtTokens.MINUSEQ, KtTokens.MULTEQ, KtTokens.DIVEQ, KtTokens.PERCEQ) to CustomHighlightsColors.KOTLIN.assignment,
)

class KotlinKeywordAnnotator : CustomKeywordAnnotator() {
    override fun classify(element: PsiElement): TextAttributesKey? {
        if (element !is LeafPsiElement) return null
        val tokenType = element.elementType
        return KOTLIN_CATEGORIES.firstOrNull { tokenType in it.first }?.second
    }
}
