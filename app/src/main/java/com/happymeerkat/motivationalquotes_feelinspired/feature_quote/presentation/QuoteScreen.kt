package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuoteScreen(
    viewModel: QuoteScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    var state = viewModel.quoteUIState.value

    Column(
        modifier = modifier
    ) {
        Text(text = state.currentQuote.content)
    }
}
