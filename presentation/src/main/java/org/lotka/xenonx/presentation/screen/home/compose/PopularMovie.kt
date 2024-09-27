package org.lotka.xenonx.presentation.screen.home.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.composable.StandardImageLazy
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun PopularMovie(
    popularMovies:List<Movies>,
    onNavigateToDetail:(String)->Unit,
    onNavigateToMoreScreen:()->Unit
){

    StandardHeaderText(
        HeaderName = "PopularMovie",
        showMoreText = true,
        onMoreClick = {
            onNavigateToMoreScreen()
        }
    )
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(SpaceMedium)
    ) {
        items(popularMovies.size){index->
            if (index!=0){
                Spacer(modifier = Modifier.width(SpaceSmall))
            }
            StandardImageLazy(
                imageUrl = BASE_POSTER_IMAGE_URL +
                        popularMovies[index].backdropPath,
                onNavigateTo = {
                    onNavigateToDetail(
                        ScreensNavigation.detailScreen.route
                                +"/${popularMovies[index].id}"
                    )
                }
            )
        }


    }}
