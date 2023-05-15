package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.categories.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryList(modifier: Modifier = Modifier, categories: List<String>) {
    LazyColumn {
        items(categories) {category ->
            Category(modifier = modifier, name = category)
        }
    }
}