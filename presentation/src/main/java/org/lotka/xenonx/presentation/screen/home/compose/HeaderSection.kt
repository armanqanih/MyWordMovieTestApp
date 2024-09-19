package org.lotka.xenonx.presentation.screen.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier
){


    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .shadow(elevation = 4.dp)
            .clip(shape = RoundedCornerShape(SpaceSmall)),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(SpaceSmall)),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                painter = painterResource(id = R.drawable.assasin ),
                contentDescription = "header" )

            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(SpaceMedium)
                ,
                textAlign = TextAlign.Start,
                text = "Assasin's Creed",
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 14.sp
                ),
                color = MaterialTheme.colors.onBackground
            )

        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
            ,modifier = Modifier
                .fillMaxWidth()
                .padding(top = SpaceSmall)
               ) {

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )


        }

    }




}