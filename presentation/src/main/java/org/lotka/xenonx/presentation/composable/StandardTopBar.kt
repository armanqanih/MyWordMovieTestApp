package org.lotka.xenonx.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.firebase.annotations.concurrent.Background
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium

@Composable
fun StandardTopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit = {},
    backgroundColor:  Color = MaterialTheme.colors.surface,
    showArrawBackIosNew: Boolean=false,
    showTopBarMenu : Boolean = false,
    showArrawBack: Boolean = false,
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
){

    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = title,
        navigationIcon = {
            if (showArrawBackIosNew){
                IconButton(onClick = {onNavigateUp()}) {
                    Icon(
                        modifier = Modifier.padding(start = SpaceMedium),
                        imageVector =  Icons.Default.ArrowBackIosNew,
                        contentDescription = "ArrowBack" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                }

            }
            else null

            if (showArrawBack){
                IconButton(onClick = {onNavigateUp() }) {
                    Icon(
                        modifier = Modifier
                            .padding(start = SpaceMedium),
                        imageVector =  Icons.Default.ArrowBack,
                        contentDescription = "ArrowBack" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                }

            }else null

            if (showTopBarMenu){
                Icon(
                    modifier = Modifier
                        .clickable {
                            onNavigateUp()
                        }
                        .padding(start = SpaceMedium),
                    imageVector =  Icons.Default.Menu,
                    contentDescription = "ArrowBack" ,
                    tint = MaterialTheme.colors.onBackground,
                )

            } else null


        },
        actions = actions,
        backgroundColor = backgroundColor,

        )

}