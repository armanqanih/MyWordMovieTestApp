package org.lotka.xenonx.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lotka.xenonx.data.remote.repository.MovieRepositoryImpl
import org.lotka.xenonx.domain.repository.MoviesRepository
import javax.inject.Singleton

/**

 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieListRepository(
        movieListRepositoryImpl: MovieRepositoryImpl
    ): MoviesRepository

}











