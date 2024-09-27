package org.lotka.xenonx.presentation.screen.book_mark

import org.lotka.xenonx.domain.model.MovieDetails
import org.lotka.xenonx.domain.model.WatchListModel

data class BookMarkState (
    val watchList: List<WatchListModel> = emptyList(),
    val movieDetails: List<MovieDetails> = emptyList(),
    val exist : Int? = 0,

)