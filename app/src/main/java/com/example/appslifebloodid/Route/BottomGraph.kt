package com.app_donor_darah.Route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appslifebloodid.Page.AboutScreen
import com.example.appslifebloodid.Page.EventScreen
import com.example.appslifebloodid.Page.HomeScreen
import com.example.appslifebloodid.Page.RiwayatScreen

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