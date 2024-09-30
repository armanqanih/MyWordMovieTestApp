package org.lotka.xenonx.presentation.screen.detail_screen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import org.lotka.xenonx.domain.model.Cast
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall
import org.lotka.xenonx.presentation.util.dimens.SpaceToLarge

@Composable
fun CastMediaSection(castList: List<Cast>) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp, top = 22.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Cast",
                fontWeight = FontWeight.Bold,
                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp
            )
        }
        LazyRow(
            modifier = Modifier.padding(
                start = 22.dp, end = 22.dp, top = 8.dp, bottom = 0.dp
            )
        ) {
            items(castList.size) { index ->
                CastMemberItem(castList[index])
            }
        }
    }


}

@Composable
fun CastMemberItem(cast: Cast) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        if (cast.profilePath != null) {
            Image(
                painter = rememberAsyncImagePainter(model = BASE_POSTER_IMAGE_URL + cast.profilePath),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                Image(
                    painter = painterResource(R.drawable.user), // Replace with your placeholder
                    contentDescription = "Cast Member Placeholder",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(4.dp))
                )
            }
        }
    }}
