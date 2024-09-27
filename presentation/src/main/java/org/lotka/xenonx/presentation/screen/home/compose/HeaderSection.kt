package org.lotka.xenonx.presentation.screen.home.compose

import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay
import org.lotka.xenonx.domain.model.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_BACKDROP_IMAGE_URL
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun HeaderSection(
    images:List<Movies>,
    modifier: Modifier = Modifier
){

    var currentIndex by remember { mutableIntStateOf(0) }

        if (images.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "OOps We Dont Have Any Image", style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.Bold
                )
            }
        } else {

            LaunchedEffect(Unit) {
                while (true) {
                    delay(6000L)
                    currentIndex = (currentIndex + 1) % images.size
                }
            }

            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val imagePainter = rememberAsyncImagePainter(
                    model = BASE_BACKDROP_IMAGE_URL +
                    images[currentIndex].backdropPath
                )

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .shadow(elevation = 4.dp)
                    .clip(shape = RoundedCornerShape(SpaceSmall)),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = imagePainter,
                        contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                        contentDescription = "header",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(SpaceSmall)),
                        )

                    Text(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(SpaceMedium)
                        ,
                        textAlign = TextAlign.Start,
                        text = images[currentIndex].title,
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

                    images.forEachIndexed { index, _ ->
                        val size by animateDpAsState(
                            targetValue = if (index == currentIndex) 12.dp else 8.dp,
                            label = ""
                        )
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .size(size)
                                .clip(CircleShape)
                                .background(if (index == currentIndex) Color.White else Color.Gray)
                        )
                    }



                }

            }

        }
    }