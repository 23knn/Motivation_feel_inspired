package com.happymeerkat.motivationalquotes_feelinspired.di

import android.app.Application
import androidx.room.Room
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.QuoteDatabase
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.repository.OfflineQuoteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.repository.OnlineQuoteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.QuoteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.GetAllQuotes
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.GetNewQuote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.QuotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideQuoteDatabase(app: Application): QuoteDatabase {
        return Room.databaseBuilder(
            app,
            QuoteDatabase::class.java,
            QuoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideOnlineQuotesRepository(db: QuoteDatabase): OnlineQuoteRepository {
        return OnlineQuoteRepository()
    }

    @Provides
    @Singleton
    fun provideOfflineQuotesRepository(db: QuoteDatabase): QuoteRepository {
        return OfflineQuoteRepository(db.getQuoteDao())
    }

    @Provides
    @Singleton
    fun provideUseCases(offlineQuoteRepository: QuoteRepository): QuotesUseCases {
        return QuotesUseCases(
            getAllQuotes = GetAllQuotes(quoteRepository = offlineQuoteRepository),
            getNewQuote = GetNewQuote()
        )
    }
}