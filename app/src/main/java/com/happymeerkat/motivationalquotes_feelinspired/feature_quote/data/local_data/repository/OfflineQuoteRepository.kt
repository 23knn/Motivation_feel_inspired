package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.repository

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.QuoteDao
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow

class OfflineQuoteRepository (private val quoteDao: QuoteDao): QuoteRepository {
    override fun getAllQuotes(): Flow<List<Quote>> {
        return quoteDao.getAllQuotes()
    }
}