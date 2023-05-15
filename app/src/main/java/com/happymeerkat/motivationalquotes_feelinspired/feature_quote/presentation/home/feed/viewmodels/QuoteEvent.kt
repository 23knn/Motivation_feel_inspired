package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels

sealed class QuoteEvent()
    object GetAllQuotesEvent: QuoteEvent()
    object GetNewQuoteEvent: QuoteEvent()
    object DownloadQuotesEvent: QuoteEvent()
    class FavoriteQuoteEvent(val quoteId: Int): QuoteEvent()

