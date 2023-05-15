package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.favorites.viewmodels

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite

data class FavoritesScreenUIState(
    val favorites: List<Favorite> = emptyList()
)
