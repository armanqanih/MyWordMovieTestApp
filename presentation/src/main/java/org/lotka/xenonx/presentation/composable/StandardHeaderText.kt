package org.lotka.xenonx.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import org.lotka.xenonx.presentation.util.dimens.SpaceLarge
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun StandardHeaderText(
    HeaderName:String,
    onMoreClick:()->Unit = {},
    showMoreText:Boolean = false,

    ){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text =  HeaderName,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            fontFamily = FontFamily.Serif

        )
        if (showMoreText){
            Row (
                modifier = Modifier.clickable {
                    onMoreClick()
                },
                horizontalArrangement =
            Arrangement.spacedBy(SpaceSmall)){
                Text(
                    text =  "more",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    fontFamily = FontFamily.Serif

                )
                Icon(imageVector = Icons.Default.ArrowForwardIos
                    , contentDescription = "",
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .size(SpaceMedium)
                    )

            }
        }


    }
}