package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

sealed class QuoteEvent {
    object GetAllQuotes: QuoteEvent()
    object GetNewQuote: QuoteEvent()

    object DownloadQuotes: QuoteEvent()
}
