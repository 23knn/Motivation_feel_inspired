package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

data class QuotesState(
    val quotes: List<Quote> = listOf(Quote(1000, "a quote")),
    val favorites: List<Int> = emptyList(),
    val currentQuote: Quote = Quote(1000, "a quote")
)
