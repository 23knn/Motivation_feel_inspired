package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes

data class QuotesUseCases(
    val getAllQuotes: GetAllQuotes,
    val getNewQuote: GetNewQuote,
    val downloadQuotes: DownloadQuotes
)
