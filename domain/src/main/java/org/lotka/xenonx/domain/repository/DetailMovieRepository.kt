package org.lotka.xenonx.domain.repository

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.model.MovieDetails
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.model.response.CastResponse
import org.lotka.xenonx.domain.util.Resource

interface DetailMovieRepository {

    fun getMoviesDetails(movieId: String): Flow<Resource<MovieDetails>>

    fun getCastMoviesRepo(movieId: String): Flow<Resource<CastResponse>>

    fun getSimilarMoviesRepo(movieId: String): Flow<Resource<List<Movies>>>


}