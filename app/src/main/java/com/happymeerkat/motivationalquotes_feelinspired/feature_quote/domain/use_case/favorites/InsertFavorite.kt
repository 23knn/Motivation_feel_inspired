package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.favorites

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class InsertFavorite(val favoriteRepository: FavoriteRepository) {
    suspend operator fun invoke(favorite: Favorite) {
        favoriteRepository.insertFavorite(favorite)
    }
}