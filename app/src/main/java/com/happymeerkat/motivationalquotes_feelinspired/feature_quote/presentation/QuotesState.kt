package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

data class QuotesState(
    val quotes: List<Quote> = emptyList(),
    val currentQuote: Quote = Quote(1, "a quote")
)
