package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.quotes_main.feed.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuoteItem(quote: String, author: String, modifier:Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = quote)
            Text(text = author)
        }
    }
}