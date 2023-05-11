package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val content: String = "default quote"
)
