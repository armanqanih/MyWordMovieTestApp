package org.lotka.xenonx.presentation.screen.detail_screen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun DetailHeaderSection(
    onNavigateUp: () -> Unit = {},
    isBookMarkClicked: Boolean = false,
    onBookmarkClick: () -> Unit = {},
    backDropImageUrl: String = "",
    posterImageUrl: String = "",
) {
    Box(modifier = Modifier.fillMaxWidth()) {

        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(
                    context = LocalContext.current
                )
                    .data(data = backDropImageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        size(Size.ORIGINAL)
                        crossfade(true)
                    }).build()
            ),
            contentDescription = "Detail Header image"
        )

        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .offset(y = (+90).dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(SpaceSmall))
                .shadow(elevation = 1.dp)
                .width(150.dp)
                .height(250.dp),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(
                    context = LocalContext.current
                ).data(posterImageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        size(Size.ORIGINAL)
                        crossfade(true)
                    }).build()
            ),
            contentDescription = "profile image"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onNavigateUp() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Detail ArrowBackIosNew",
                    tint = MaterialTheme.colors.onBackground
                )
            }
            IconButton(onClick = {
                onBookmarkClick()
            }) {
                if (isBookMarkClicked){
                    Icon(
                        imageVector = Icons.Filled.BookmarkBorder,
                        contentDescription = "Detail Bookmark",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
                Icon(
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = "Detail Bookmark",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        }


    }
}