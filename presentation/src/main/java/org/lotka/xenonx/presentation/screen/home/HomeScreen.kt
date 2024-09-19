package org.lotka.xenonx.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.StandardTopBar
import org.lotka.xenonx.presentation.screen.home.compose.HeaderSection
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun HomeScreen (
   onNavigateToSearchScreen: (String) -> Unit = {},
   onNavigateToBooMarkScreen: (String) -> Unit = {},
) {


    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar ={
            StandardTopBar(
                modifier = Modifier.fillMaxWidth(),
                showArrawBack = false,
                title = {
                    Text(text = "My World Movie",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground)
                },
                actions = {
                    Icon(
                        modifier = Modifier.clickable {
                            onNavigateToSearchScreen(
                                ScreensNavigation.searchScreen.route
                            )
                        },
                        imageVector =  Icons.Default.Search,
                        contentDescription = "search" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                    Spacer(modifier = Modifier.width(SpaceMedium))
                    Icon(
                        modifier = Modifier.clickable {
                            onNavigateToBooMarkScreen(
                                ScreensNavigation.bookMarkScreen.route
                            )
                        },
                        imageVector =  Icons.Default.Bookmarks,
                        contentDescription = "search" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                }
            )
        }
        ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(it),
            contentAlignment = Alignment.Center
            ){
            LazyColumn(modifier = Modifier.fillMaxSize()
                .padding(SpaceMedium)
            ) {

                item {
                  HeaderSection()
                }


            }
        }

    }


}