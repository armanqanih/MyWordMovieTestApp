package org.lotka.xenonx.presentation.screen.see_all

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.composable.StandardTopBar
import org.lotka.xenonx.presentation.screen.see_all.compose.SeeAllCardItem
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceToLarge

@Composable
fun SeeAllScreen(
    onNavigateUp: () -> Unit = {},
    onNavigateToSearch: (String) -> Unit = {},
){

    val scaffoldState = rememberScaffoldState()

    Scaffold(modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            StandardTopBar(
                onNavigateUp = onNavigateUp,
                title = {
                    Text(
                        text = "               See All"
                        , color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = SpaceToLarge)
                    )
                },
                showArrawBackIosNew = true
                , actions = {
                    IconButton(onClick = {
                     onNavigateToSearch(ScreensNavigation.searchScreen.route)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search" ,
                            tint = MaterialTheme.colors.onBackground
                            )

                    }
                }

            )
        }
        ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it))
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium),
            verticalArrangement = Arrangement.spacedBy(SpaceMedium),
            horizontalArrangement = Arrangement.spacedBy(SpaceMedium)
        ){
          items(10){
              SeeAllCardItem()
          }
        }
    }



}