package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels.FavoriteQuoteEvent
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels.QuoteScreenViewModel
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.util.QuoteItem

@Composable
fun QuoteFeed(
    quotes: List<Quote>,
    quoteVM: QuoteScreenViewModel = hiltViewModel(),
    modifier:Modifier = Modifier
) {
    val quoteState = quoteVM.quoteState.collectAsState().value
    val favorites: List<Favorite> = quoteVM.favoriteUIState.collectAsState().value.favorites
    val faveUnfave: (Quote) -> Unit = { quote -> quoteVM.onEvent(FavoriteQuoteEvent(quote))}
    LazyColumn(modifier = modifier) {
        items(quotes) {quote ->
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                faveUnfave = { faveUnfave(quote) },
                isFave = favorites.contains(Favorite(1, quote.id)),
                modifier = Modifier.fillMaxWidth()
            )
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                faveUnfave = { faveUnfave(quote) },
                isFave = favorites.contains(Favorite(1, quote.id)),
                modifier = Modifier.fillMaxWidth()
            )
            QuoteItem(
                quote = quote.content,
                author = quote.author,
                faveUnfave = { faveUnfave(quote) },
                isFave = favorites.contains(Favorite(1, quote.id)),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}