package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main.feed.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.QuotesUseCases
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
class QuoteScreenViewModel @Inject constructor(private val quotesUseCases: QuotesUseCases): ViewModel() {
    private val _quoteUIState = MutableStateFlow(QuotesState())
    val quoteUIState: StateFlow<QuotesState> = _quoteUIState

    private var getQuotesJob: Job? = null
    init {
        downloadQuotes()
        getQuotes()
    }
    fun onEvent(event: QuoteEvent) {
        when(event) {
            is QuoteEvent.GetAllQuotes -> {
                getQuotes()
            }

            is QuoteEvent.GetNewQuote -> {
                getNewQuote()
            }

            is QuoteEvent.DownloadQuotes -> {
                downloadQuotes()
            }
        }
    }

    private fun downloadQuotes() {
        viewModelScope.launch {
            quotesUseCases.downloadQuotes()
        }
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
}