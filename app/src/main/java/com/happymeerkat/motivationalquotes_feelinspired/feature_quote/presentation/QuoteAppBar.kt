package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.happymeerkat.motivationalquotes_feelinspired.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = { Text(stringResource(id = R.string.app_name)) },
        /*navigationIcon = {
            IconButton(onClick = { } ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back"
                )
            }
        }*/
    )
}