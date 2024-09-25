package org.lotka.xenonx.presentation.screen.home.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.domain.model.Genre
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun Genre (
  genre:List<Genre>,
  onNavigateTo:(String)->Unit
){

    StandardHeaderText(HeaderName = "Genre")

    LazyRow (modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(SpaceSmall)
        ) {

        items(genre.size) { indxt->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(40.dp))
                    .background(color = MaterialTheme.colors.primary)
                    .clickable {
                    onNavigateTo(
                        ScreensNavigation.genryVisyScreen.route
                         +"/${genre[indxt].id}"
                         +"/${genre[indxt].name}"
                    )

                    }
            ) {

                Text(
                    modifier = Modifier.padding(SpaceSmall)                        ,
                    text = genre[indxt].name,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.body1,

                    )
            }
        }


    }

}