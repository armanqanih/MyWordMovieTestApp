package org.lotka.xenonx.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium

@Composable
fun StandardImageLazy(
    imageUrl:String,
    titleVisible:Boolean = false,
    backgroundOfTitleVisible:Boolean=false,
    text:String = "",
    onNavigateTo:()->Unit = {},
    hightOfImage:Dp = 150.dp,
    widthOfImage:Dp = 120.dp
){

    if (imageUrl.isNotEmpty()){
        Box(modifier = Modifier
            .height(hightOfImage)
            .width(widthOfImage)
            .clip(shape = RoundedCornerShape(SpaceMedium))
            .shadow(elevation = 4.dp)
            .clickable {
                onNavigateTo()
            }
        ) {

            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(SpaceMedium)),
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            size(Size.ORIGINAL)
                            scale(Scale.FILL)
                            crossfade(true)
                        }).build()
                ),
                contentDescription = "header image"

            )
            if (titleVisible){
               Text(
                   text = text,
                   style = MaterialTheme.typography.body1,
                   color = MaterialTheme.colors.onBackground,
                   modifier = Modifier
                       .fillMaxWidth()
                       .background(
                           if (backgroundOfTitleVisible)
                       MaterialTheme.colors.surface
                       else null !!
                       )
                       .align(Alignment.BottomCenter)
                   )
            }
        }
    }
    else{
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(SpaceMedium)),
            painter = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = "header image"

        )
    }}

