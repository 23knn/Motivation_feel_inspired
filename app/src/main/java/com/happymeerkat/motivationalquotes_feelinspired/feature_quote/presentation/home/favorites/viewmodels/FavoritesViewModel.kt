package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.presentation.home.favorites.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.use_case.favorites.GetAllFavorites
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val getAllFavorites: GetAllFavorites): ViewModel() {
    private var getFavoritesJob: Job? = null
    private val _favoriteUIState = mutableStateOf(FavoritesScreenUIState())
    val favoriteUIState = _favoriteUIState
    init {
        getAllFavorites()
    }
    private fun getFavorites() {
        getFavoritesJob?.cancel()
        getFavoritesJob = getAllFavorites()
            .onEach { favoritesList ->
                _favoriteUIState.value = favoriteUIState.value.copy(favorites = favoritesList)
            }
            .launchIn(viewModelScope)
    }

}