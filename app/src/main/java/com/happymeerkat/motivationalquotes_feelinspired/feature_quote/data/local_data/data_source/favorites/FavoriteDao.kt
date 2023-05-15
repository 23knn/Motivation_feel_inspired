package com.happymeerkat.motivationalquotes_feelinspired.feature_quote.data.local_data.data_source.favorites

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.happymeerkat.motivationalquotes_feelinspired.feature_quote.domain.model.Favorite
import kotlinx.coroutines.flow.Flow
@Dao
interface FavoriteDao {
    @Query("SELECT * FROM Favorite")
    fun getAllFavorites(): Flow<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)

}