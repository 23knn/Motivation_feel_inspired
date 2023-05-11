package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey
    val id: Int = 0,
    val content: String = "default quote"
)
