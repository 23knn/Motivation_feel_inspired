package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.favorites

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.FavoriteRepository

class DeleteFavorite(val favoriteRepository: FavoriteRepository) {
    suspend operator fun invoke(favorite: Favorite) {
        favoriteRepository.deleteFavorite(favorite = favorite)
    }
}