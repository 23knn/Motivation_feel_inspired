package com.happymeerkat.motivationalquotes_feelinspired

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.QuoteAppBar
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.QuoteBottomBar
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.QuoteScreen
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.Settings.Settings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    fun currentScreen(): String{ return backStackEntry?.destination?.route ?: BottomNavigationScreens.Home.route }

    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Settings
    )

    Scaffold(
        topBar = { QuoteAppBar()},
        bottomBar = {
                QuoteBottomBar(
                    navController = navController,
                    items = bottomNavigationItems,
                    currentScreen =  {currentScreen()}
                )
            }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavigationScreens.Home.route,
            modifier = Modifier.padding(contentPadding)
        ){
            composable(BottomNavigationScreens.Home.route) {
                QuoteScreen(
                    modifier = modifier.padding(contentPadding)
                )
            }

            composable(BottomNavigationScreens.Settings.route) {
                Settings()
            }

        }


    }
}

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : BottomNavigationScreens("home", R.string.home, Icons.Filled.Home)
    object Settings : BottomNavigationScreens("settings", R.string.settings, Icons.Filled.Settings)
}