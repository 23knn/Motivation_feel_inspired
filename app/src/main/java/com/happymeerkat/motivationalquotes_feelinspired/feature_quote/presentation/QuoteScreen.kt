package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuoteScreen(
    modifier: Modifier = Modifier,
    viewModel: QuoteScreenViewModel = hiltViewModel()
){
    val state = viewModel.quoteUIState.collectAsState().value
    QuoteFeed(quotes = state.quotes)
}
