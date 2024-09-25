package org.lotka.xenonx.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertMovie(movies: List<MoviesEntity>)

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id: Int): MoviesEntity?


    @Query("SELECT * FROM movies WHERE category = :category")
    suspend fun getMoviesByCategory(category: String): List<MoviesEntity>

    @Query("DELETE FROM movies WHERE id =:id")
    suspend fun removeFromList(id: Int)

//    @Query("DELETE FROM movies")
//    suspend fun deleteList()
//
//    @Query("SELECT EXISTS (SELECT 1 FROM movies WHERE id = :id)")
//    suspend fun exists(id: Int): Int
//
//    @Query("SELECT * FROM movies ORDER BY id DESC")
//    fun getAllWatchListData(): Flow<List<MoviesEntity>>
}

