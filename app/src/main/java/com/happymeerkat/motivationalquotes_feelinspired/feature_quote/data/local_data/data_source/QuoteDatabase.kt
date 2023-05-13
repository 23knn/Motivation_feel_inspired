package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

@Database(
    entities = [Quote::class],
    version = 3,
    exportSchema = false
)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao

    companion object {
        val DATABASE_NAME = "Quote_Database"
    }
}