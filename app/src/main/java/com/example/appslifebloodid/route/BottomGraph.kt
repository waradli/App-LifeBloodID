package com.app_donor_darah.Route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appslifebloodid.page.AboutScreen
import com.example.appslifebloodid.page.Component.NavigateScreen.KebijakanPrivasi
import com.example.appslifebloodid.page.Component.NavigateScreen.KetentuanPengguna
import com.example.appslifebloodid.page.Component.NavigateScreen.Pertanyaan
import com.example.appslifebloodid.page.Component.NavigateScreen.PusatBantuan
import com.example.appslifebloodid.page.Component.NavigateScreen.TentangAplikasi
import com.example.appslifebloodid.page.EventScreen
import com.example.appslifebloodid.page.HomeScreen
import com.example.appslifebloodid.page.RiwayatScreen

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
    }
}