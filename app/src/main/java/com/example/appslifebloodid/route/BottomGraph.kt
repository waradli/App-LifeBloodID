package com.app_donor_darah.Route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appslifebloodid.intro.onboarding.components.menu_home.ScreenChat
import com.example.appslifebloodid.intro.onboarding.components.menu_home.ScreenReward
import com.example.appslifebloodid.page.AboutScreen
import com.example.appslifebloodid.page.Component.NavigateScreen.KebijakanPrivasi
import com.example.appslifebloodid.page.Component.NavigateScreen.KetentuanPengguna
import com.example.appslifebloodid.page.Component.NavigateScreen.Pertanyaan
import com.example.appslifebloodid.page.Component.NavigateScreen.PusatBantuan
import com.example.appslifebloodid.page.Component.NavigateScreen.TentangAplikasi
import com.example.appslifebloodid.page.EventScreen
import com.example.appslifebloodid.page.HomeScreen
import com.example.appslifebloodid.page.RiwayatScreen
import com.example.appslifebloodid.route.RouteBotNav

@Composable
fun BottomGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = RouteBotNav.Home.route) {
        composable(route = RouteBotNav.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = RouteBotNav.Riwayat.route) {
            RiwayatScreen()
        }
        composable(route = RouteBotNav.Event.route) {
            EventScreen()
        }
        composable(route = RouteBotNav.About.route) {
            AboutScreen(navController = navController)
        }

        // New Screen About
        composable(route = "TentangAplikasi"){
            TentangAplikasi(navController = navController)
        }
        composable(route = "Kebijakan&Privasi"){
            KebijakanPrivasi(navController = navController)
        }
        composable(route = "PusatBantuan"){
            PusatBantuan(navController = navController)
        }
        composable(route = "KetentuanPengguna"){
            KetentuanPengguna(navController = navController)
        }
        composable(route = "PertanyaanYangSeringDitanyakan"){
            Pertanyaan(navController = navController)
        }

        //ScreenMenuHome
        composable(route = "ScreenReward"){
            ScreenReward(navController = navController)
        }
        composable(route = "ScreenChat"){
            ScreenChat(navController = navController)
        }
    }
}