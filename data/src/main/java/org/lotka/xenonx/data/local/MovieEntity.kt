package org.lotka.xenonx.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import org.lotka.xenonx.data.converter.Converters
import org.lotka.xenonx.domain.model.Genre
import org.lotka.xenonx.domain.model.Movies

@Entity(tableName = "movies")
@TypeConverters(Converters::class)
data class MoviesEntity(
    @PrimaryKey
    val id: Int,

    val adult: Boolean,

    val backdropPath: String?,

    val posterPath: String?,

    val genreIds: String?,

    val genres: List<Genre>?,

    val mediaType: String?,

    val imdbId: String?,

    val originalLanguage: String,

    val overview: String,

    val popularity: Double,

    val releaseDate: String,

    val runtime: Int?,

    val title: String,

    val video: Boolean,

    val voteAverage: Double,

    val voteCount: Int,

    val category: String
)

fun Movies.toMoviesEntity(
    category: String
): MoviesEntity {
    return MoviesEntity(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        posterPath = posterPath,
        genreIds = try {
            genreIds?.joinToString { " , " }?:"-1,-2"
        }catch (e:Exception){
            "-1,-2"
        },
        genres = genres,
        mediaType = mediaType,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        overview = overview,
        popularity = popularity,
        releaseDate = releaseDate,
        runtime = runtime,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        category = category
    )
}





fun MoviesEntity.toMovies(
    category: String
): Movies {
    return Movies(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        posterPath = posterPath,
        genreIds = try {
                       genreIds?.split(",")?.map {
                           it.toInt()
                       }

        }catch (e:Exception){
           listOf(-1,-2)
        },
        genres = genres,
        mediaType = mediaType,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        overview = overview,
        popularity = popularity,
        releaseDate = releaseDate,
        runtime = runtime,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        category = category
    )
}

