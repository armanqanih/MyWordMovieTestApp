package org.lotka.xenonx.presentation.screen.detail_screen.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.github.mikephil.charting.components.Description

import org.lotka.xenonx.presentation.util.dimens.SpaceLarge
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceToLarge

@Composable
fun MovieInformation(
    ReleaseDate: String,
    Duration: String,
    Rating: String,
    Language: String,

){
    Column(modifier = Modifier.fillMaxWidth()
        .padding(horizontal = SpaceToLarge),
        ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            HeaderTextInformation(title = "Release Date",
                subTitle =ReleaseDate )
            Spacer(modifier = Modifier.width(SpaceToLarge))

            HeaderTextInformation(title = "Duration",
                subTitle = Duration )
            Spacer(modifier = Modifier.width(SpaceToLarge))

            HeaderTextInformation(title = "Rating",
                subTitle =Rating ,
                showRatingIcon = true
            )
            Spacer(modifier = Modifier.width(SpaceToLarge))
            HeaderTextInformation(title = "Language",
                subTitle = Language )
        }

        Spacer(modifier = Modifier.height(SpaceLarge))

        Text(
            text = "Come Together .",
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.h2.copy(
                fontSize = 12.sp,
            ),
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(SpaceMedium))




    }

}
