package org.lotka.xenonx.presentation.screen.see_all.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall
import org.lotka.xenonx.presentation.util.dimens.SpaceToLarge
import org.lotka.xenonx.presentation.util.dimens.SpaceVeryLarge

@Composable
fun SeeAllCardItem(

){
    Card(modifier = Modifier
        .height(300.dp)
        .width(200.dp)
        .clip(shape = RoundedCornerShape(SpaceMedium))
        .shadow(elevation = 2.dp)
        ,
        colors =  CardColors(
            containerColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onBackground,
            disabledContainerColor = MaterialTheme.colors.surface,
            disabledContentColor = MaterialTheme.colors.onBackground
        )
    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(SpaceSmall)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Image(painter = painterResource(id = R.drawable.pobg),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                    .weight(1f)
                    .padding(bottom = SpaceSmall)
                    .clip(RoundedCornerShape(SpaceMedium))

            )
            Text(text = "NameOfMovie",
                maxLines = 1,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
                , modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp)

                )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                Icon(imageVector = Icons.Default.Star,
                    contentDescription = "Star"
                    ,tint = MaterialTheme.colors.secondary
                    , modifier = Modifier.size(SpaceMedium)
                )
                Text(text = "7.7",
                    maxLines = 1,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Medium
                )
            }



        }


    }


}