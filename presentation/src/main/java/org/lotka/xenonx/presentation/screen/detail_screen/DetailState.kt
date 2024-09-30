package org.lotka.xenonx.presentation.screen.detail_screen

import org.lotka.xenonx.domain.model.Cast
import org.lotka.xenonx.domain.model.MovieDetails
import org.lotka.xenonx.domain.model.Movies

data class DetailState (
    val isLoading: Boolean = false,
    val movieDetail: MovieDetails? = null,
    val listOfDetail: List<MovieDetails> = emptyList(),
    val castList: List<Cast> = emptyList(),
    val movies:List<Movies> = emptyList(),
    val error: String = "",
)