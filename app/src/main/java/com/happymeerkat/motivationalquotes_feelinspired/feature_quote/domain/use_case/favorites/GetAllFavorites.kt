package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.favorites

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavorites @Inject constructor(val favoriteRepository: FavoriteRepository) {
    operator fun invoke(): Flow<List<Favorite>> {
        return favoriteRepository.getAllFavorites()
    }
}