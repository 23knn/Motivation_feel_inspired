package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main

sealed class HomeContent {
    object Favorites: HomeContent()
    object Categories: HomeContent()
    object Feed: HomeContent()
}
