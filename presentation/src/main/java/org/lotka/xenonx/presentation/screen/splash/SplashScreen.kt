package org.lotka.xenonx.presentation.screen.splash

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.core.animation.OvershootInterpolator
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants.SPLASH_SCREEN_DURATION


@Composable
fun SplashScreen(
  navController: NavController,
  dispatcher: CoroutineDispatcher = Dispatchers.Main,
//  onPopBackStack: () -> Unit = {},
//  onNavigate: (String) -> Unit = {}
){
    Box(modifier = Modifier.fillMaxSize()
    , contentAlignment = Alignment.Center
    ){

        val scope = rememberCoroutineScope()

        val scale = remember {
            androidx.compose.animation.core.Animatable(0f)
        }
        val overshootInterpolator = remember {
            OvershootInterpolator(2f)
        }


        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            kotlinx.coroutines.delay(SPLASH_SCREEN_DURATION)
            navController.popBackStack()
            navController.navigate(ScreensNavigation.homeScreen.route)
        }


        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo" ,
            modifier = Modifier.scale(scale.value)

        )

    }
}