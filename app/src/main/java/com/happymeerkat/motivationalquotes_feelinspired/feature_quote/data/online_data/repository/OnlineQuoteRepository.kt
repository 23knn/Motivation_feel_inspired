package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.repository

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.data_source.QuoteService
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow

class OnlineQuoteRepository(private val onlineQuoteService: QuoteService) {
    private val fakeOnlineQuotesResult = listOf<Quote>(
        Quote(1, "“Sometimes life is like this dark tunnel. You can't always see the light at the end of the tunnel, but if you just keep moving... you will come to a better place.”"),
        Quote(2, "When you're in your darkest place, you give yourself hope and that's inner strength."),
        Quote(3, "Sometimes the best way to solve your own problems is to help someone else"),
        Quote(4, "Life happens wherever you are, whether you make it or not."),
    )
    suspend fun getAllQuotes(): List<Quote> {
        // return onlineQuoteService.getAllQuotes()
        return fakeOnlineQuotesResult
    }
}