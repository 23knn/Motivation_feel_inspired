package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.util.FaveUnfaveQuoteViewModel
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.util.QuoteItem

@Composable
fun QuoteFeed(
    quotes: List<Quote>,
    faveUnfave: (Int) -> Unit,
    quoteVM: FaveUnfaveQuoteViewModel = hiltViewModel(),
    modifier:Modifier = Modifier
) {
    val quoteState = quoteVM.quoteState.collectAsState().value

    LazyColumn(modifier = modifier) {
        items(quotes) {quote ->
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                faveUnfave = { faveUnfave(quote.id) },
                isFave = quoteState.favorited,
                modifier = Modifier.fillMaxWidth()
            )
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                faveUnfave = { faveUnfave(quote.id) },
                isFave = quoteState.favorited,
                modifier = Modifier.fillMaxWidth()
            )
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                faveUnfave = { faveUnfave(quote.id) },
                isFave = quoteState.favorited,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}