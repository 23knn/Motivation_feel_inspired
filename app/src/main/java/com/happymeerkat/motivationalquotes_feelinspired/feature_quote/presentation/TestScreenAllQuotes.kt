package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun TestScreenAllQuotes(viewModel: QuoteScreenViewModel = hiltViewModel()) {
    val state = viewModel.quoteUIState.value

    Column {
        Button(onClick = { viewModel.onEvent(event = QuoteEvent.DownloadQuotes) }) {
            Text("Download Quotes")
        }
        Text(state.quotes.size.toString())
        LazyColumn {
            items(state.quotes) {quote ->
                Text(quote.content)
            }
        }
    }

}