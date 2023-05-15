package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.quotes

import android.util.Log
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.online_data.repository.OnlineQuoteRepository

class DownloadQuotes(private val onlineQuoteRepository: OnlineQuoteRepository) {
    suspend operator fun invoke() {
        Log.d("FIXING", "did download invoke run?")
        onlineQuoteRepository.insertDownloadedQuotesToOfflineDB()
    }
}