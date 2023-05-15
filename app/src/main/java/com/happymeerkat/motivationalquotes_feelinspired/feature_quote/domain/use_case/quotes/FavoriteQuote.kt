package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.repository.FavoriteRepository
import javax.inject.Inject

class FavoriteQuote (private val faveRepository: FavoriteRepository) {
    suspend operator fun invoke(fave: Favorite) {
        faveRepository.insertFavorite(fave)
    }
}