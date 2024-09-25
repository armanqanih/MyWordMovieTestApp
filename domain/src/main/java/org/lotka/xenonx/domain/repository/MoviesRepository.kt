package org.lotka.xenonx.domain.repository

import android.graphics.Movie

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.API_KEY
import org.lotka.xenonx.domain.util.Resource

interface MoviesRepository {

    suspend fun getMovies(
        fromFetchForRemote:Boolean,
        category: String,
        page: Int,
    ):Flow<Resource<List<Movies>>>

    suspend fun getMovie(id:Int):Flow<Resource<Movies>>

}