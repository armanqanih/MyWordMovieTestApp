package org.lotka.xenonx.presentation.screen.home

import org.lotka.xenonx.domain.model.Genre
import org.lotka.xenonx.domain.model.Movies

data class HomeState(
    val movies: List<Movies> = emptyList(),
    val popularMovies: List<Movies> = emptyList(),
    val popularPage:Int = 1,
    val upComingMovies: List<Movies> = emptyList(),
    val upComingPage:Int = 1,
    val dicCoverMovies: List<Movies> = emptyList(),
    val dicCoverPage:Int = 1,
    val nowPlayingMovies: List<Movies> = emptyList(),
    val nowPlayingPage:Int = 1,
    val geners: List<Genre> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,

        )