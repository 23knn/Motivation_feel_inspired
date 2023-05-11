


package com.happymeerkat.motivationalquotes_feelinspired

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.QuoteScreen
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.TestScreenAllQuotes
import com.happymeerkat.motivationalquotes_feelinspired.ui.theme.MotivationFeelInspiredTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivationFeelInspiredTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TestScreenAllQuotes()
                    // QuoteScreen()
                }
            }
        }
    }
}
