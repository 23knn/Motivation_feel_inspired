package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.happymeerkat.motivationalquotes_feelinspired.R

@Composable
fun Home(modifier: Modifier = Modifier) {
    var content: HomeContent by remember { mutableStateOf(HomeContent.Feed) }

    Column {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TabButton(name = stringResource(id = R.string.QuotesTab), changeContent = { content = HomeContent.Feed })
            TabButton(name = stringResource(id = R.string.FavoritesTab), changeContent = { content = HomeContent.Favorites })
            TabButton(name = stringResource(id = R.string.CategoriesTab), changeContent = { content = HomeContent.Categories })
        }
        HomeContainer(content = content)
    }
}

@Composable
fun TabButton(name: String, changeContent: () -> Unit) {
    TextButton(
        onClick = { changeContent() }
    ) {
        Text(text = name)
    }
}