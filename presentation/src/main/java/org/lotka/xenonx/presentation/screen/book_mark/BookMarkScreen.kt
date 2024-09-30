package org.lotka.xenonx.presentation.screen.book_mark

import android.widget.Toast
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.composable.StandardTopBar
import org.lotka.xenonx.presentation.screen.book_mark.compose.BookMarkItem
import org.lotka.xenonx.presentation.screen.book_mark.compose.DismissBackground
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.dimens.SpaceMedium
import org.lotka.xenonx.presentation.util.dimens.SpaceSmall

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookMarkScreen(
    viewModel: BookMarkViewModel = hiltViewModel(),
    onNavigateToSearch:(String) -> Unit={},
    onNavigateToDetail:(String) -> Unit={},
    onNavigateUp:()->Unit={},
){

    val state = viewModel.state.collectAsState().value

    val context = LocalContext.current


 Scaffold(modifier = Modifier.fillMaxSize(),
     topBar = {
         StandardTopBar(
             modifier = Modifier.fillMaxWidth(),
             title = {
                 Text(text = "                   BookMark${state.watchList.size}",
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
         if (state.watchList.isEmpty()){
                Text(text = "Book Mark Is Empty",
                 style = MaterialTheme.typography.h1,
                 color = MaterialTheme.colors.onBackground
                 , textAlign = TextAlign.Center
             )
         }
         LazyColumn(modifier = Modifier.fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.spacedBy(SpaceSmall)
             ) {

             items(state.watchList.size) {indxt->
                 val imageUrl = state.watchList[indxt].imagePath?.let { BASE_POSTER_IMAGE_URL + it }
                 val movie = state.watchList[indxt]
                 val dismissState = rememberSwipeToDismissBoxState(
                     confirmValueChange = {
                         when (it) {
                             SwipeToDismissBoxValue.EndToStart -> {
                                 viewModel.removeFromList(movie.mediaId)
                                 Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT)
                                     .show() }
                             SwipeToDismissBoxValue.Settled -> {
                                 return@rememberSwipeToDismissBoxState false }

                             SwipeToDismissBoxValue.StartToEnd -> {} }
                             return@rememberSwipeToDismissBoxState true },
                             // positional threshold of 25%
                              positionalThreshold = { it * .25f })


                 SwipeToDismissBox(
                     state = dismissState,
                     enableDismissFromStartToEnd = false,
                     backgroundContent = { DismissBackground(dismissState) },
                     content = {
                         BookMarkItem(
                             imageUrl = imageUrl ?: "",
                             title = movie.title ?: "",
                             timestamp = movie.releaseDate ?: "",
                             onNavigateToDetail ={
                                 onNavigateToDetail(
                                     ScreensNavigation.detailScreen.route + "/${movie.mediaId}")
                             }
                         )
                     })





             }
         }
     }
 }




}
