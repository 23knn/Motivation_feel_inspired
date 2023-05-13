package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote

@Composable
fun QuoteFeed(quotes: List<Quote>, modifier:Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(top = 50.dp)) {
        items(quotes) {quote ->
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                modifier = Modifier.fillMaxWidth()
            )
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                modifier = Modifier.fillMaxWidth()
            )
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}