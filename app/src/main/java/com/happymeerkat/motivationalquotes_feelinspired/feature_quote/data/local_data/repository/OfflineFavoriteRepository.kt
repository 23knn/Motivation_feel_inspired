package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.repository

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.favorites.FavoriteDao
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class OfflineFavoriteRepository(private val favoriteDao: FavoriteDao): FavoriteRepository {
    override fun getAllFavorites(): Flow<List<Favorite>> = favoriteDao.getAllFavorites()

    override suspend fun insertFavorite(favorite: Favorite) = favoriteDao.insertFavorite(favorite)

    override suspend fun deleteFavorite(favorite: Favorite) = favoriteDao.deleteFavorite(favorite)
}