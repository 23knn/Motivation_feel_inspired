package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    fun getAllQuotes(): Flow<List<Quote>>
}