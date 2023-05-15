package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.FavoriteQuote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels.FavoriteQuoteEvent
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels.QuoteEvent
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels.QuoteScreenViewModel

@Composable
fun QuoteScreen(
    modifier: Modifier = Modifier,
    viewModel: QuoteScreenViewModel = hiltViewModel()
){
    val state = viewModel.quoteUIState.collectAsState().value
    QuoteFeed(
        quotes = state.quotes,
        faveUnfave = { quoteId -> viewModel.onEvent(FavoriteQuoteEvent(quoteId)) }
    )
}
