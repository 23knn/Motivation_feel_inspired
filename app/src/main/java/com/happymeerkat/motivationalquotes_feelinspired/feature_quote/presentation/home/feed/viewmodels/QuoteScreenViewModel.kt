package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.feed.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.favorites.FavoritesUseCases
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.favorites.GetAllFavorites
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.QuotesUseCases
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.util.QuoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class QuoteScreenViewModel @Inject constructor(
    private val quotesUseCases: QuotesUseCases,
    private val favoritesUseCases: FavoritesUseCases
): ViewModel() {
    // all quotes
    private val _quoteUIState = MutableStateFlow(QuotesState())
    val quoteUIState: StateFlow<QuotesState> = _quoteUIState

    // all favorites
    private val _favoriteUIState = MutableStateFlow(FavoritesScreenUIState())
    val favoriteUIState: StateFlow<FavoritesScreenUIState> = _favoriteUIState

    // individual quote favorite status
    private val _quoteState = MutableStateFlow(QuoteState())
    val quoteState: StateFlow<QuoteState> = _quoteState

    private var getQuotesJob: Job? = null
    private var getFavoritesJob: Job? = null

    init {
        downloadQuotes()
        getFavorites()
        getQuotes()
    }
    fun onEvent(event: QuoteEvent) {
        when(event) {
            is GetAllQuotesEvent -> {
                getQuotes()
            }

            is GetNewQuoteEvent -> {
                getNewQuote()
            }

            is DownloadQuotesEvent -> {
                downloadQuotes()
            }

            is FavoriteQuoteEvent -> {
                favoriteQuote(event.quote)
            } //TODO: move this to the logic of individual quotes
        }
    }

    private fun downloadQuotes() {
        viewModelScope.launch {
            quotesUseCases.downloadQuotes()
        }
    }

    private fun getFavorites() {
        getFavoritesJob?.cancel()
        getFavoritesJob = favoritesUseCases.getAllFavorites()
            .onEach { favoritesList ->
                _favoriteUIState.value = favoriteUIState.value.copy(favorites = favoritesList)
            }
            .launchIn(viewModelScope)
    }
    private fun getQuotes() {
        getQuotesJob?.cancel()
        getQuotesJob = quotesUseCases.getAllQuotes()
            .onEach { quotesList ->
                _quoteUIState.value = quoteUIState.value.copy(quotes = quotesList)
            }
            .launchIn(viewModelScope)
    }

    private fun getNewQuote() {
        val idx = Random.nextInt(_quoteUIState.value.quotes.size)
        val quote = _quoteUIState.value.quotes[idx]
        Log.d("FIXING", "$quote")
        _quoteUIState.value = quoteUIState.value.copy(currentQuote = quote)
    }

    private fun favoriteQuote(quote: Quote) {
        viewModelScope.launch {
            val fave: Favorite = Favorite(userId = 1, quoteId = quote.id)
            if(favoriteUIState.value.favorites.contains(fave)) {
                favoritesUseCases.deleteFavorite(fave)
            } else{
                favoritesUseCases.insertFavorite(fave)
            }
        }
    }


}