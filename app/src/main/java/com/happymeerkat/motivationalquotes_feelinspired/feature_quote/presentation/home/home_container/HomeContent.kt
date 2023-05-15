package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.home_container

sealed class HomeContent {
    object Favorites: HomeContent()
    object Categories: HomeContent()
    object Feed: HomeContent()
}
