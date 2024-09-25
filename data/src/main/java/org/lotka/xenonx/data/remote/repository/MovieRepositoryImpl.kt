package org.lotka.xenonx.data.remote.repository

import coil.network.HttpException
import io.grpc.internal.SharedResourceHolder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lotka.xenonx.data.api.ApiService
import org.lotka.xenonx.data.local.MovieDatabase
import org.lotka.xenonx.data.local.toMovies
import org.lotka.xenonx.data.remote.Dto.models.toMovie
import org.lotka.xenonx.data.remote.Dto.models.toMovieEntity
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.repository.MoviesRepository
import org.lotka.xenonx.domain.util.Resource
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api : ApiService ,
    private val db : MovieDatabase
):MoviesRepository {
    override suspend fun getMovies(
        fromFetchForRemote: Boolean,
        category: String,
        page: Int,
    ): Flow<Resource<List<Movies>>> {
       return flow {
           emit(Resource.Loading(true))

           val localMovies = db.movieDao().getMoviesByCategory(category)
           if (localMovies.isEmpty() && !fromFetchForRemote){
           emit(Resource.Success(localMovies.map { it.toMovies(category) }))

               emit(Resource.Loading(false))
               return@flow
           }
            val movieListFromApi = try {
                api.getMovies(page = page, category = category)
            }catch (e:IOException){
                e.printStackTrace()
                emit(Resource.Error("Oops Something went Wrong"))
                return@flow
            }catch (e:HttpException){
                e.printStackTrace()
                emit(Resource.Error("Oops Something went Wrong"))
                return@flow
            }
           val movieEntity = movieListFromApi.results.map { it.toMovieEntity() }
           db.movieDao().upsertMovie(movieEntity)
           emit(Resource.Success(
               movieEntity.map { it.toMovies(category) }
           ))
           emit(Resource.Loading(false))

       }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movies>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val movieEntity = db.movieDao().getMovieById(id)
                if (movieEntity != null) {
                    emit(Resource.Success(movieEntity.toMovies(movieEntity.category)))
                }
                emit(Resource.Loading(false))

            } catch (e: Exception) {
              emit(Resource.Error("Oops Some things Went Wrong"))
            }

        }}
}