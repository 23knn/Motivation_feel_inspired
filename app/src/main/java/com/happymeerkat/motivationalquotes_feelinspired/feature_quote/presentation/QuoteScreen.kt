package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuoteScreen(
    viewModel: QuoteScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    var state = viewModel.quoteUIState.collectAsState().value
    QuoteFeed(quotes = state.quotes)
}
