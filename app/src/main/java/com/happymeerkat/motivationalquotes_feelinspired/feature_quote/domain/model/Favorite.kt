package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey
    val userId: Int,
    val quoteId: Int
)
