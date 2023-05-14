package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main.categories.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Category(modifier: Modifier = Modifier, name: String) {
    Text(name)
}