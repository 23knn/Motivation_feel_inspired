package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case

import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.repository.OnlineQuoteRepository

class DownloadQuotes(private val onlineQuoteRepository: OnlineQuoteRepository) {
    suspend operator fun invoke() {
        onlineQuoteRepository.insertDownloadedQuotesToOfflineDB()
    }
}