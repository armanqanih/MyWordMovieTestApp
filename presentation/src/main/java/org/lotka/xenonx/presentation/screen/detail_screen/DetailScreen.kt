package org.lotka.xenonx.presentation.screen.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.lotka.xenonx.domain.model.WatchListModel
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_BACKDROP_IMAGE_URL
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL

import org.lotka.xenonx.presentation.screen.book_mark.BookMarkViewModel

import org.lotka.xenonx.presentation.screen.detail_screen.compose.CastMediaSection
import org.lotka.xenonx.presentation.screen.detail_screen.compose.DetailHeaderSection
import org.lotka.xenonx.presentation.screen.detail_screen.compose.GenreChip
import org.lotka.xenonx.presentation.screen.detail_screen.compose.MovieInformation
import org.lotka.xenonx.presentation.screen.detail_screen.compose.OverviewSection
import org.lotka.xenonx.presentation.screen.detail_screen.compose.SimilarMediaSection


import org.lotka.xenonx.presentation.util.UiEvent
import org.lotka.xenonx.presentation.util.dimens.SpaceLarge

import java.text.SimpleDateFormat
import java.util.Date


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel=hiltViewModel(),
    bookMarkViewModel: BookMarkViewModel = hiltViewModel(),
    onNavigateUp:()->Unit={},
    onNavigateTo:(String)->Unit={},
){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val detailState = detailViewModel.state.collectAsState().value
    val bookMarkState = bookMarkViewModel.state.collectAsState().value
    val movieDetail = detailState.movieDetail
    var exist = bookMarkState.exist
    val date = SimpleDateFormat.getDateInstance().format(Date())
    val myListMovie = WatchListModel(
        mediaId = movieDetail!!.id,
        imagePath = movieDetail.posterPath,
        title = movieDetail.title,
        releaseDate = movieDetail.releaseDate,
        rating = movieDetail.voteAverage,
        addedOn = date
    )

    LaunchedEffect(key1 = true){
        bookMarkViewModel.sharedFlow.collect{event->
            when(event){
                is UiEvent.ShowSnakeBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }}
    }


        LazyColumn(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            ){

            item {
                DetailHeaderSection(
                    backDropImageUrl = BASE_BACKDROP_IMAGE_URL + movieDetail.backdropPath,
                    posterImageUrl   = BASE_POSTER_IMAGE_URL + movieDetail.posterPath ,
                    onNavigateUp = onNavigateUp,
                    isBookMarkClicked = if (exist != 0) false else true,
                    onBookmarkClick = {
                        if (exist != 0){
                            bookMarkViewModel.removeFromList(movieDetail.id)
                        }else{
                            bookMarkViewModel.addToBookMark(myListMovie)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(110.dp))
                Text(text = movieDetail.title,
                    style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground,)
            }
            item {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FlowRow(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalArrangement = Arrangement.Center
                    ) {
                     movieDetail.genres.forEach {
                         GenreChip(genre = it.name)
                     }

                    }
                }
            }
            item {
                MovieInformation(
                    ReleaseDate = movieDetail.releaseDate,
                    Duration = movieDetail.runtime.toString() + "min"  ,
                    Rating = movieDetail.voteAverage.toString(),
                    Language = movieDetail.spokenLanguages[0].name,
                    )

            }
            item {
//                overview
                movieDetail.overview?.let {
                    OverviewSection(overview = it, tagline = movieDetail.tagline) }
            }

//            Cast

            item {
                Spacer(modifier = Modifier.height(SpaceLarge))
                CastMediaSection(castList = detailState.castList)
            }


// Similar Movies
            item {
                Spacer(modifier = Modifier.height(SpaceLarge))
                SimilarMediaSection(
                    onNavigateToDetail = onNavigateTo,
                    media = detailState.movies)
            }}

}


