package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main.feed.viewmodels

sealed class QuoteEvent {
    object GetAllQuotes: QuoteEvent()
    object GetNewQuote: QuoteEvent()
    object DownloadQuotes: QuoteEvent()
}
