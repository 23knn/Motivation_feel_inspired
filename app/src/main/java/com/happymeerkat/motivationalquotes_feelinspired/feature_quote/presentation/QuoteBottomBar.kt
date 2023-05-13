package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.happymeerkat.motivationalquotes_feelinspired.BottomNavigationScreens

@Composable
fun QuoteBottomBar(
    navController: NavHostController,
    items: List<BottomNavigationScreens>,
    currentScreen: () -> String
) {
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentScreen() == screen.route,
                onClick = {
                    if (currentScreen() != screen.route) {
                        navController.navigate(screen.route)
                    }
                },
                label = { Text(screen.route) },
                icon = { Icon( Icons.Filled.Build, contentDescription = null ) }
            )
        }
    }

}