package org.lotka.xenonx.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.data.local.model.MoviesEntity
import org.lotka.xenonx.data.local.model.WatchListEntity

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertMovieInList(watchListModel: WatchListEntity)

    @Query("DELETE FROM movies WHERE id =:id")
    suspend fun removeFromList(id: Int)

    @Query("SELECT * FROM watch_list_table ORDER BY addedOn DESC")
    fun getAllWatchListData(): Flow<List<WatchListEntity>>

    @Query("DELETE FROM watch_list_table")
    suspend fun deleteList()

    @Query("SELECT EXISTS (SELECT 1 FROM watch_list_table WHERE mediaId = :mediaId)")
    suspend fun exists(mediaId: Int): Int

    @Upsert
    suspend fun upsertMovie(movies: List<MoviesEntity>)

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id: Int): MoviesEntity?


    @Query("SELECT * FROM movies WHERE category = :category")
    suspend fun getMoviesByCategory(category: String): List<MoviesEntity>



}