package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.repository

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.QuoteDao
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.QuoteRepository

class OfflineQuoteRepository(private val quoteDao: QuoteDao): QuoteRepository {
}