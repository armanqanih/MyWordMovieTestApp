package org.lotka.xenonx.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.lotka.xenonx.data.api.ApiService
import org.lotka.xenonx.data.converter.Converters
import org.lotka.xenonx.data.local.MovieDatabase
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverters(gson: Gson): Converters {
        return Converters(gson)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }


    @Provides
    @Singleton
    fun providesMovieDatabase(app: Application,converters: Converters): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "movie"
        ).addTypeConverter(converters)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviesDao(db: MovieDatabase) = db.movieDao()
}