package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes.QuotesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FaveUnfaveQuoteViewModel @Inject constructor(private val quotesUseCases: QuotesUseCases): ViewModel() {
    private val _quoteState = MutableStateFlow(QuoteState())
    val quoteState: StateFlow<QuoteState> = _quoteState

    private fun favoriteQuote(userId: Int ,quoteId: Int) {
        viewModelScope.launch {
            val fave = Favorite(userId, quoteId)
            val isFave = _quoteState.value.favorited
            _quoteState.value = quoteState.value.copy(favorited = !isFave)
            quotesUseCases.favoriteQuote(fave)
        }
    }
}