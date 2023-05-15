package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuoteItem(
    quote: String,
    author: String,
    isFave: Boolean,
    faveUnfave: () -> Unit,
    modifier:Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = modifier.padding(top = 20.dp, bottom = 20.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = quote,
                fontSize = 22.sp,
            )
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(onClick = { faveUnfave() }) {
                    Icon(
                        imageVector = if(isFave) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "back"
                    )
                }

                Text(
                    text = author,
                    fontSize = 25.sp
                )


            }

        }
    }
}