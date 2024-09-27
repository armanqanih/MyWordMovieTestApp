package org.lotka.xenonx.presentation.screen.home


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks

import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.hilt.navigation.compose.hiltViewModel
import org.lotka.xenonx.domain.util.Constants.Companion.nowPlayingAllListScreen
import org.lotka.xenonx.domain.util.Constants.Companion.popularAllListScreen

import org.lotka.xenonx.presentation.composable.StandardTopBar
import org.lotka.xenonx.presentation.screen.home.compose.Genre
import org.lotka.xenonx.presentation.screen.home.compose.HeaderSection
import org.lotka.xenonx.presentation.screen.home.compose.NowPlaying
import org.lotka.xenonx.presentation.screen.home.compose.PopularMovie
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium

@Composable
fun HomeScreen (
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToSearchScreen: (String) -> Unit = {},
    onNavigateToBooMarkScreen: (String) -> Unit = {},
    onNavigateToGenreScreen: (String) -> Unit = {},
    onNavigateToDetail: (String) -> Unit = {},
    onNavigateToMoreScreen:(String)-> Unit = {}
) {

   val state = viewModel.state.collectAsState().value

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar ={
            StandardTopBar(
                modifier = Modifier.fillMaxWidth(),
                showArrawBack = false,
                title = {
                    Text(text = "My World Movie",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground)
                },
                actions = {
                    Icon(
                        modifier = Modifier.clickable {
                            onNavigateToSearchScreen(
                                ScreensNavigation.searchScreen.route
                            )
                        },
                        imageVector =  Icons.Default.Search,
                        contentDescription = "search" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                    Spacer(modifier = Modifier.width(SpaceMedium))
                    Icon(
                        modifier = Modifier
                            .clickable {
                                onNavigateToBooMarkScreen(
                                    ScreensNavigation.bookMarkScreen.route
                                )
                            }
                            .padding(end = SpaceMedium),
                        imageVector =  Icons.Default.Bookmarks,
                        contentDescription = "search" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                }
            )
        }
        ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(it),
            contentAlignment = Alignment.Center
            ){
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium),
                verticalArrangement = Arrangement.spacedBy(SpaceMedium)
            ) {

                item {
                  HeaderSection(
                      modifier = Modifier.fillMaxWidth(),
                      images = state.movies,
                      )
                }
                item {
               Genre(
                   genre = state.geners,
                   onNavigateTo = onNavigateToGenreScreen
                   )
                }
                item {
                    NowPlaying(
                        nowPlayingmovies = state.nowPlayingMovies ,
                        onNavigateToDetail = onNavigateToDetail,
                        onNavigateToMoreScreen = {
                        onNavigateToMoreScreen(
                            ScreensNavigation.seeAllScreen.route +
                                    "/$nowPlayingAllListScreen")
                        }
                    )
                }
                item {
                    PopularMovie(
                        popularMovies = state.popularMovies
                        , onNavigateToDetail = onNavigateToDetail
                    , onNavigateToMoreScreen = {
                            ScreensNavigation.seeAllScreen.route +
                                    "/$popularAllListScreen"
                        }
                    )
                }


            }
        }

    }


}