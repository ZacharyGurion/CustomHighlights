package com.github.zacharygurion.customhighlights.Annotators

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement

abstract class CustomKeywordAnnotator : Annotator {

    protected abstract fun classify(element: PsiElement): TextAttributesKey?

    final override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val key = classify(element) ?: return
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(key)
            .create()
    }
}
