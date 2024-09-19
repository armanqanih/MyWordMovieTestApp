package org.lotka.xenonx.data.remote.Dto.models

import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.domain.model.Genre
import org.lotka.xenonx.domain.model.Search


data class SearchDto(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("genres")
    val genres: List<Genre>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("origin_country")
    val originCountry: List<String>?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date", alternate = ["first_air_date"])
    val releaseDate: String?,
    @SerializedName("title", alternate = ["name"])
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)


fun SearchDto.toSearch(): Search {
    return Search(
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        genres = genres,
        id = id,
        imdbId = imdbId,
        mediaType = mediaType,
        originCountry = originCountry,
        originalLanguage = originalLanguage,
        originalName = originalName,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        runtime = runtime,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}
