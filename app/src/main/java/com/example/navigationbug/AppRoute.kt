package com.example.navigationbug

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import androidx.navigation.compose.composable
import com.example.navigationbug.screens.FirstScreen
import com.example.navigationbug.screens.SecondScreen
import com.example.navigationbug.screens.ThirdScreen
import timber.log.Timber

internal const val navigationRoute = "route"

private const val firstScreen = "route/first"
private const val secondScreen = "route/second"
private const val thirdScreen = "route/third"

internal fun NavGraphBuilder.appNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = firstScreen,
        route = navigationRoute
    ) {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Timber.d(
                "BackStackLog, Current ${controller.currentBackStackEntry?.destination?.route ?: ""}, " +
                        "Previous ${controller.previousBackStackEntry?.destination?.route ?: ""}"
            )
        }
        composable(route = firstScreen) {
            FirstScreen {
                navController.navigate(secondScreen)
            }
        }
        composable(route = secondScreen) {
            SecondScreen {
                navController.navigate(thirdScreen)
            }
        }
        composable(route = thirdScreen) {
            ThirdScreen()
        }
    }
}