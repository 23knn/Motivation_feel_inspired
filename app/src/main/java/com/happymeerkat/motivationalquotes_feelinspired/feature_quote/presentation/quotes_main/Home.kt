package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.happymeerkat.motivationalquotes_feelinspired.R

@Composable
fun Home() {
    var content: HomeContent by remember { mutableStateOf(HomeContent.Feed) }

    Column {
        Row {
            Button(onClick = { content = HomeContent.Feed }) {
                Text(text = stringResource(id = R.string.QuotesTab))
            }

            Button(onClick = { content = HomeContent.Favorites }) {
                Text(text = stringResource(id = R.string.FavoritesTab))
            }

            Button(onClick = { content = HomeContent.Categories }) {
                Text(text = stringResource(id = R.string.CategoriesTab))
            }
        }
        HomeContainer(content = content)
    }
}