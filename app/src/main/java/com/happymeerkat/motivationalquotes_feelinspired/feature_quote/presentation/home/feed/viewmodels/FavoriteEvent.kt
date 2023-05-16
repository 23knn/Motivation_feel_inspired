package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels

sealed class FavoriteEvent {
    object GetAllFavorites: FavoriteEvent()
    object GetNewFavorite: FavoriteEvent()
    object DownloadFavorites: FavoriteEvent()
}
