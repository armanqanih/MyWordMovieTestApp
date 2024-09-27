package org.lotka.xenonx.presentation.screen.book_mark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.lotka.xenonx.presentation.composable.StandardTopBar
import org.lotka.xenonx.presentation.screen.book_mark.compose.BookMarkItem
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@Composable
fun BookMarkScreen(
  onNavigateToSearch:(String) -> Unit={},
  onNavigateUp:()->Unit={},
){


 Scaffold(modifier = Modifier.fillMaxSize(),
     topBar = {
         StandardTopBar(
             modifier = Modifier.fillMaxWidth(),
             title = {
                 Text(text = "                      BookMark",
                     style = MaterialTheme.typography.body1,
                     color = MaterialTheme.colors.onBackground
                     )
             },
             onNavigateUp = onNavigateUp,
              showArrawBackIosNew = true,
              actions = {
                 Icon(
                     imageVector = Icons.Default.Search ,
                     contentDescription = "bookMark Search",
                     tint = MaterialTheme.colors.onBackground
                     )

             }
         )
     }
     ) {
     Box (modifier = Modifier
         .fillMaxSize()
         .padding(it)){
         LazyColumn(modifier = Modifier.fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.spacedBy(SpaceSmall)
             ) {
             items(10) {
             BookMarkItem()

             }
         }
     }
 }




}
