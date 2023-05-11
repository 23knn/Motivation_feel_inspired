package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Quote
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.QuotesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class QuoteScreenViewModel @Inject constructor(private val quotesUseCases: QuotesUseCases): ViewModel() {
    private val _quoteUIState = mutableStateOf(QuotesState())
    val quoteUIState: State<QuotesState> = _quoteUIState

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
                val idx = Random.nextInt(_quoteUIState.value.quotes.size)
                val quote = _quoteUIState.value.quotes[idx]
                _quoteUIState.value = quoteUIState.value.copy(currentQuote = quote)
            }

            is QuoteEvent.DownloadQuotes -> {
                downloadQuotes()
            }
        }
    }

    fun downloadQuotes() {
        viewModelScope.launch {
            quotesUseCases.downloadQuotes()
            getQuotes()
        }
    }
    fun getQuotes() {
        getQuotesJob?.cancel()
        getQuotesJob = quotesUseCases.getAllQuotes()
            .onEach { quotesList ->
                _quoteUIState.value = quoteUIState.value.copy(quotes = quotesList)
            }
            .launchIn(viewModelScope)

    }
}