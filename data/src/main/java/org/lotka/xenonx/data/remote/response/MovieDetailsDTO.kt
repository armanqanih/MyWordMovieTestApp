package org.lotka.xenonx.data.remote.response

import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.GenreDto
import org.lotka.xenonx.data.remote.Dto.models.toGenre
import org.lotka.xenonx.domain.model.MovieDetails


data class MovieDetailsDTO(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionDto?,
    @SerializedName("budget")
    val budget: Long,
    @SerializedName("genres")
    val genres: List<GenreDto>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryDto>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Long,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
) {

    
    data class BelongsToCollectionDto(
        @SerializedName("backdrop_path")
        val backdropPath: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("poster_path")
        val posterPath: String
    )

    
    data class ProductionCompanyDto(
        @SerializedName("id")
        val id: Int,
        @SerializedName("logo_path")
        val logoPath: String?,
        @SerializedName("name")
        val name: String,
        @SerializedName("origin_country")
        val originCountry: String
    )

    
    data class ProductionCountryDto(
        @SerializedName("iso_3166_1")
        val iso31661: String,
        @SerializedName("name")
        val name: String
    )

    
    data class SpokenLanguageDto(
        @SerializedName("iso_639_1")
        val iso6391: String,
        @SerializedName("name")
        val name: String
    )
}

fun MovieDetailsDTO.toMovieDetail(): MovieDetails {
    return MovieDetails(
        adult = adult,
        backdropPath = backdropPath,
        belongsToCollection = belongsToCollection?.let {
            MovieDetails.BelongsToCollection(
                id = it.id,
                name = it.name,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath
            )
        },
        budget = budget,
        genres = genres.map {it.toGenre()},
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies.map { companyDto ->
            MovieDetails.ProductionCompany(
                id = companyDto.id,
                logoPath = companyDto.logoPath,
                name = companyDto.name,
                originCountry = companyDto.originCountry
            )
        },
        productionCountries = productionCountries.map { countryDto ->
            MovieDetails.ProductionCountry(
                iso31661 = countryDto.iso31661,
                name = countryDto.name
            )
        },
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages.map { languageDto ->
            MovieDetails.SpokenLanguage(
                iso6391 = languageDto.iso6391,
                name = languageDto.name
            )
        },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}


