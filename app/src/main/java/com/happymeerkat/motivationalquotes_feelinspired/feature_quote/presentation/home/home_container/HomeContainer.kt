package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.home_container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.screens.QuoteScreen
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.settings.Settings

@Composable
fun HomeContainer(
    content: HomeContent, modifier: Modifier = Modifier,

    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        when(content) {
            is HomeContent.Feed -> QuoteScreen()
            is HomeContent.Categories -> Settings()
            is HomeContent.Favorites -> Settings()
        }
    }
}