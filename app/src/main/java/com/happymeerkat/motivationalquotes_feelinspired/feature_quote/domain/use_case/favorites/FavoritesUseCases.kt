package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.favorites

data class FavoritesUseCases(
    val getAllFavorites: GetAllFavorites,
    val removeFavorite: RemoveFavorite
)
