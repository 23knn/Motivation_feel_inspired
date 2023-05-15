package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.quotes

import androidx.room.Database
import androidx.room.RoomDatabase
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.favorites.FavoriteDao
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

@Database(
    entities = [
        Quote::class,
        Favorite::class
               ],
    version = 5,
    exportSchema = false
)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
    abstract fun getFavoriteDao(): FavoriteDao

    companion object {
        val DATABASE_NAME = "Quote_Database"
    }
}