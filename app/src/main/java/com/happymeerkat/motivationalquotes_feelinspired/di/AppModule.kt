package com.happymeerkat.motivationalquotes_feelinspired.di

import android.app.Application
import androidx.room.Room
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.QuoteDatabase
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
    fun provideNoteDatabase(app: Application): QuoteDatabase {
        return Room.databaseBuilder(
            app,
            QuoteDatabase::class.java,
            QuoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideOnlineQuotesRepository(db: NoteDatabase): NoteRepository {
        return OfflineNoteRepository(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideOfflineQuotesRepository(db: NoteDatabase): NoteRepository {
        return OfflineNoteRepository(db.noteDao)
    }
}