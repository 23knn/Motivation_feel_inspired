package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main.feed.viewmodels

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

data class QuotesState(
    val quotes: List<Quote> = listOf(Quote(1, "a quote")),
    val currentQuote: Quote = Quote(1, "a quote")
)
