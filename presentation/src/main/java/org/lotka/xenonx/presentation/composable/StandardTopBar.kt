package org.lotka.xenonx.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium

@Composable
fun StandardTopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit = {},
    showArrawBack: Boolean = false,
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
){

    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = title,
        navigationIcon = {
            if (showArrawBack){
                Icon(
                    modifier = Modifier.clickable {
                        onNavigateUp()
                    }.padding(start = SpaceMedium),
                    imageVector =  Icons.Default.ArrowBack,
                    contentDescription = "ArrowBack" ,
                    tint = MaterialTheme.colors.onBackground,
                )
            }else{
                Icon(
                    modifier = Modifier.clickable {
                        onNavigateUp()
                    }.padding(start = SpaceMedium),
                    imageVector =  Icons.Default.Menu,
                    contentDescription = "ArrowBack" ,
                    tint = MaterialTheme.colors.onBackground,
                )
            }

        },
        actions = actions,
        backgroundColor = MaterialTheme.colors.surface,

        )

}