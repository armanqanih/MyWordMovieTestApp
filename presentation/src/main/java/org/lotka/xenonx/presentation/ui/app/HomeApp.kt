package org.lotka.xenonx.presentation.ui.app


import android.annotation.SuppressLint
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import org.lotka.xenonx.presentation.screen.book_mark.BookMarkScreen
import org.lotka.xenonx.presentation.screen.detail_screen.DetailScreen
import org.lotka.xenonx.presentation.screen.home.HomeScreen
import org.lotka.xenonx.presentation.screen.see_all.SeeAllScreen

import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.screen.splash.SplashScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeApp(
    activity: HomeActivity,
    navController: NavHostController,
    onNavigateToRecipeDetailScreen: (String) -> Unit,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    keyboardController: SoftwareKeyboardController,

    ) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val scaffoldState = rememberScaffoldState()




    Scaffold(

        content = { _ ->
            NavHost(
                navController = navController,
                startDestination = ScreensNavigation.seeAllScreen.route,
            ) {
                composable(
                    route = ScreensNavigation.spalshScreen.route,
                ) {
                    SplashScreen(navController = navController)
                }
                composable(
                    route = ScreensNavigation.detailScreen.route,
                ) {
                    DetailScreen(
                        onNavigateUp = navController::navigateUp
                    )
                }
                composable(
                    route = ScreensNavigation.seeAllScreen.route,
                ) {
                    SeeAllScreen(
                        onNavigateUp = navController::navigateUp
                    )
                }
                composable(
                    route = ScreensNavigation.bookMarkScreen.route,
                ) {
                    BookMarkScreen(
                        onNavigateToSearch = navController::navigate,
                        onNavigateUp = navController::navigateUp
                    )
                }

                composable(
                    route = ScreensNavigation.homeScreen.route,
                ) {
                    HomeScreen(
                        onNavigateToMoreScreen = navController::navigate,
                        onNavigateToDetail = navController::navigate,
                        onNavigateToGenreScreen = navController::navigate,
                        onNavigateToSearchScreen = navController::navigate,
                        onNavigateToBooMarkScreen = navController::navigate
                    )
                }
                composable(
                    route = ScreensNavigation.genryVisyScreen.route
                            + "/{genreId}" + "/{genreName}",
                    arguments = listOf(
                        navArgument("genreId") { type = NavType.StringType },
                        navArgument("genreName") { type = NavType.StringType },
                    )

                ) {


                }


            }

        },
    )

}



