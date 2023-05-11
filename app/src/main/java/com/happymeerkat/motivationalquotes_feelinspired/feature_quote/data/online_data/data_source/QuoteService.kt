package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.data_source

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import retrofit2.http.GET

interface QuoteService {
    @GET(".")
    suspend fun getAllQuotes(): List<Quote>
}