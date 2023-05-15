package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.quotes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import kotlinx.coroutines.flow.Flow
@Dao
interface QuoteDao {
    @Query("SELECT * FROM Quote")
    fun getAllQuotes(): Flow<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuote(quote: Quote)

}