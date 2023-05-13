package com.happymeerkat.motivationalquotes_feelinspired

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.QuoteAppBar
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.QuoteScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { QuoteAppBar()},
    ) { contentPadding ->
            QuoteScreen(modifier = modifier.padding(contentPadding))

    }
}