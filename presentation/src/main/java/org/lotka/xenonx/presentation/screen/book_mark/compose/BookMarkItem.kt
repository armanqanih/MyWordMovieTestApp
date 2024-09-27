package org.lotka.xenonx.presentation.screen.book_mark.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall


@Composable
fun BookMarkItem (

){

    Row (modifier = Modifier.fillMaxWidth().
        padding(top = SpaceMedium, start = SpaceSmall)
        .clip(RoundedCornerShape(topStart = SpaceMedium,
            bottomStart = SpaceMedium
        ))
        .background(color = MaterialTheme.colors.surface)
        , verticalAlignment = Alignment.CenterVertically
        ){
        Image(painter = painterResource(id = R.drawable.assasin),
            contentDescription ="ImageBookMark" ,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(150.dp)
                .width(140.dp).
            clip(shape = RoundedCornerShape(SpaceMedium)),

            )
        Column(
            modifier = Modifier.padding(start = SpaceMedium),
            verticalArrangement = Arrangement.spacedBy(SpaceSmall)
            , horizontalAlignment = Alignment.Start
        ){

            Text(text = "Assasin's Creed",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
                )
            Text(text = "1-12-2023",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Medium
            )

        }
    }

}