package com.github.zacharygurion.customhighlights.Annotators

import com.github.zacharygurion.customhighlights.CustomHighlightsColors
import com.intellij.openapi.editor.colors.TextAttributesKey

private val SQL_CATEGORIES: List<Pair<Set<String>, TextAttributesKey>> = listOf(
    setOf(
        "IF", "ELSE", "ELSEIF", "ELSIF",
        "CASE", "WHEN", "THEN", "END",
        "BEGIN",
        "LOOP", "WHILE", "REPEAT", "UNTIL",
        "LEAVE", "ITERATE",
        "RETURN", "RAISE"
    ) to CustomHighlightsColors.SQL.controlFlow,

    setOf(
        "INT", "INTEGER", "BIGINT", "SMALLINT", "TINYINT",
        "FLOAT", "DOUBLE", "REAL", "DECIMAL", "NUMERIC",
        "CHAR", "VARCHAR", "TEXT", "NCHAR", "NVARCHAR",
        "BOOLEAN", "BOOL",
        "DATE", "TIME", "TIMESTAMP", "DATETIME", "INTERVAL",
        "BLOB", "CLOB", "BINARY", "VARBINARY",
        "JSON", "XML", "UUID"
    ) to CustomHighlightsColors.SQL.literalType,

    setOf("NULL") to CustomHighlightsColors.SQL.nullLiteral,
    setOf("TRUE") to CustomHighlightsColors.SQL.trueLiteral,
    setOf("FALSE") to CustomHighlightsColors.SQL.falseLiteral,

    setOf("+", "-", "*", "/", "%") to CustomHighlightsColors.SQL.arithmetic,
    setOf("AND", "OR", "NOT") to CustomHighlightsColors.SQL.logical,
    setOf("=", "!=", "<>", "<", ">", "<=", ">=") to CustomHighlightsColors.SQL.comparison,
    // SQL has no assignment operators in DML; = is comparison in WHERE clauses
)

class SqlKeywordAnnotator : LeafTextKeywordAnnotator() {
    override val categories = SQL_CATEGORIES
    override val caseSensitive = false
}
