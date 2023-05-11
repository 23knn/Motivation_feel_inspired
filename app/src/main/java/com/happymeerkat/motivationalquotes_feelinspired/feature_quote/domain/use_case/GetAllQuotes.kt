package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllQuotes(val quoteRepository: QuoteRepository) {
    operator fun invoke(): Flow<List<Quote>> {
        return quoteRepository.getAllQuotes()
    }
}