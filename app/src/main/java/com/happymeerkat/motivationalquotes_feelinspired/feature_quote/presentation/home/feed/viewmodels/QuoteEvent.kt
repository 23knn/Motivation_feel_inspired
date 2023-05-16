package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

sealed class QuoteEvent()
    object GetAllQuotesEvent: QuoteEvent()
    object GetNewQuoteEvent: QuoteEvent()
    object DownloadQuotesEvent: QuoteEvent()
    class FavoriteQuoteEvent(val quote: Quote): QuoteEvent()

