package com.app_donor_darah.Route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cobaa.projectmassive.Screen.AboutScreen
import com.cobaa.projectmassive.Screen.EventScreen
import com.cobaa.projectmassive.Screen.HomeScreen
import com.cobaa.projectmassive.Screen.RiwayatScreen

@Composable
fun BottomGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination =RouteBotNav.Home.route) {
        composable(route = RouteBotNav.Home.route) {
            HomeScreen()
        }
        composable(route = RouteBotNav.Riwayat.route) {
            RiwayatScreen()
        }
        composable(route = RouteBotNav.Event.route) {
            EventScreen()
        }
        composable(route = RouteBotNav.About.route) {
            AboutScreen()
        }
    }
}