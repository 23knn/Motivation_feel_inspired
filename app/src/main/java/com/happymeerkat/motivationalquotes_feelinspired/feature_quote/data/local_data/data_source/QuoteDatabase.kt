package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source

import androidx.room.Database
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

@Database(
    entities = [Quote::class],
    version = 1
)
abstract class QuoteDatabase {
    abstract fun getQuoteDao(): QuoteDao

    companion object {
        val DATABASE_NAME = "Quote_Database"
    }
}