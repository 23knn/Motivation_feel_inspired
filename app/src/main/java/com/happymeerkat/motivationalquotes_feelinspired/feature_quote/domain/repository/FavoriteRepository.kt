package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getAllFavorites(): Flow<List<Favorite>>
    suspend fun insertFavorite(favorite: Favorite)
    suspend fun deleteFavorite(favorite: Favorite)
}