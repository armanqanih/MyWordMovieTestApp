package org.lotka.xenonx.data.remote.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lotka.xenonx.data.api.ApiService
import org.lotka.xenonx.data.remote.Dto.models.toMovie
import org.lotka.xenonx.data.remote.response.toMovieDetail
import org.lotka.xenonx.domain.model.MovieDetails
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.model.response.CastResponse
import org.lotka.xenonx.domain.repository.DetailMovieRepository
import org.lotka.xenonx.domain.util.Resource
import java.io.IOException
import javax.inject.Inject

class DetailMovieRepositoryImpl @Inject constructor(
    private val api: ApiService
): DetailMovieRepository {
    override fun getMoviesDetails(movieId: String): Flow<Resource<MovieDetails>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val resultRemote = api.getMoviesDetails(movieId.toInt()).toMovieDetail()
                emit(Resource.Success(resultRemote))
                emit(Resource.Loading(false))

            }catch(e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Oops Something went Wrong"))
                return@flow
            } catch (e:Exception){
                e.printStackTrace()
                emit(Resource.Error(e.message.toString()))
                return@flow
            }
        }
    }

    override fun getCastMoviesRepo(movieId: String): Flow<Resource<CastResponse>> {
       return flow {
           try {
               emit(Resource.Loading(true))
               val resultRemote = api.getMovieCast(movieId.toInt())
               emit(Resource.Success(resultRemote))
               emit(Resource.Loading(false))

           }catch(e:IOException){
               e.printStackTrace()
               emit(Resource.Error("Oops Something went Wrong"))
               return@flow
           } catch (e:Exception){
               e.printStackTrace()
               emit(Resource.Error(e.message.toString()))
               return@flow
           }
       }
    }

    override fun getSimilarMoviesRepo(movieId: String): Flow<Resource<List<Movies>>> {
       return flow {
           try {
               emit(Resource.Loading(true))
               val resultRemote = api.getSimilarMovies(movieId.toInt()).results.map { it.toMovie() }
               emit(Resource.Success(resultRemote))
               emit(Resource.Loading(false))

           }catch(e:IOException){
               e.printStackTrace()
               emit(Resource.Error("Oops Something went Wrong"))
               return@flow
           } catch (e:Exception){
               e.printStackTrace()
               emit(Resource.Error(e.message.toString()))
               return@flow
           }
       }
    }


}