package org.lotka.xenonx.presentation.screen.home.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.composable.StandardImageLazy
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun NowPlaying(
    nowPlayingmovies:List<Movies> ,
    onNavigateToDetail:(String)->Unit,
    onNavigateToMoreScreen:()->Unit
){

    StandardHeaderText(
        HeaderName = "NowPlaying",
        showMoreText = true,
        onMoreClick = {
            onNavigateToMoreScreen()
        }
        )
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(SpaceMedium)
        ) {
            items(nowPlayingmovies.size){index->
                if (index!=0){
                    Spacer(modifier = Modifier.width(SpaceSmall))
                }
                StandardImageLazy(
                    imageUrl = BASE_POSTER_IMAGE_URL +
                            nowPlayingmovies[index].backdropPath,
                    onNavigateTo = {
                        onNavigateToDetail(
                            ScreensNavigation.detailScreen.route
                            +"/${nowPlayingmovies[index].id}"
                        )
                    }
                )
            }


        }



}