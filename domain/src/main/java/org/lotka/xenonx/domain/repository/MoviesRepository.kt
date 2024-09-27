package org.lotka.xenonx.domain.repository

import android.graphics.Movie

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.model.WatchListModel
import org.lotka.xenonx.domain.util.Constants.Companion.API_KEY
import org.lotka.xenonx.domain.util.Resource

interface MoviesRepository {

    suspend fun getMovies(
        fromFetchForRemote:Boolean,
        category: String,
        page: Int,
    ):Flow<Resource<List<Movies>>>

    suspend fun getMovie(id:Int):Flow<Resource<Movies>>


    suspend fun getNowPlayingMovies(
        fromFetchForRemote:Boolean,
         page: Int,
    ):Flow<Resource<List<Movies>>>


    suspend fun getDiscoverMovies(page: Int):Flow<Resource<List<Movies>>>



    suspend fun insertMovieInList(watchListModel: WatchListModel)
    suspend fun removeFromList(id: Int)
    fun getAllWatchListData(): Flow<List<WatchListModel>>
    suspend fun deleteList()
    suspend fun exists(mediaId: Int): Int


}