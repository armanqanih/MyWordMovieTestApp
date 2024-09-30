package org.lotka.xenonx.presentation.screen.detail_screen.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium

@Composable
fun OverviewSection(overview: String, tagline: String?) {
    Column {
        Text(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = tagline!!,
            fontSize = 17.sp,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.onBackground,        )

        Spacer(modifier = Modifier.height(SpaceMedium))


        Text(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = overview,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            lineHeight = 16.sp
        )

    }
}