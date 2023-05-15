package com.happymeerkat.motivationalquotes_feelinspired.di

import android.app.Application
import androidx.room.Room
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.quotes.QuoteDatabase
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.repository.OfflineFavoriteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.repository.OfflineQuoteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.data_source.QuoteService
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.repository.OnlineQuoteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.FavoriteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.QuoteRepository
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.DownloadQuotes
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.FavoriteQuote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.GetAllQuotes
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.GetNewQuote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.QuotesUseCases
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQuoteService(app: Application): QuoteService {
        val baseUrl = "https://google.com"
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()

        val retrofitService: QuoteService by lazy {retrofit.create(QuoteService::class.java)}

        return retrofitService
    }

    @Provides
    @Singleton
    fun provideQuoteDatabase(app: Application): QuoteDatabase {
        return Room.databaseBuilder(
            app,
            QuoteDatabase::class.java,
            QuoteDatabase.DATABASE_NAME,
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideOnlineQuotesRepository(quoteService: QuoteService, db: QuoteDatabase): OnlineQuoteRepository {
        return OnlineQuoteRepository(quoteService, db.getQuoteDao())
    }

    @Provides
    @Singleton
    fun provideOfflineQuotesRepository(db: QuoteDatabase): QuoteRepository {
        return OfflineQuoteRepository(db.getQuoteDao())
    }

    @Provides
    @Singleton
    fun provideOfflineFavoriteRepository(db: QuoteDatabase): FavoriteRepository {
        return OfflineFavoriteRepository(db.getFavoriteDao())
    }

    @Provides
    @Singleton
    fun provideUseCases(
        offlineQuoteRepository: QuoteRepository,
        onlineQuoteRepository: OnlineQuoteRepository,
        faveRepository:FavoriteRepository
    ): QuotesUseCases {
        return QuotesUseCases(
            getAllQuotes = GetAllQuotes(quoteRepository = offlineQuoteRepository),
            getNewQuote = GetNewQuote(),
            downloadQuotes = DownloadQuotes(onlineQuoteRepository = onlineQuoteRepository),
            favoriteQuote = FavoriteQuote(faveRepository = faveRepository)
        )
    }
}