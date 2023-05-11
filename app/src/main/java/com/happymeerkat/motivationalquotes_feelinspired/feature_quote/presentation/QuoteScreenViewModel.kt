package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.lifecycle.ViewModel
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.QuotesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class QuoteScreenViewModel(private val quotesUseCases: QuotesUseCases): ViewModel() {

}