package org.lotka.xenonx.domain.model


import org.lotka.xenonx.domain.model.Genre


data class Movies(

    val adult: Boolean,

    val backdropPath: String?,

    val posterPath: String?,

    val genreIds: List<Int>?,

    val genres: List<Genre>?,

    val mediaType: String?,

    val id: Int,

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
