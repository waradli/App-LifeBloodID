package com.app_donor_darah.Route

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.DetailArtikel
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.DetailEvent
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.ScreenJadwalDonor
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.chat.ScreenChat
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.ScreenReward
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.ScreenStockDarah
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.chat.ScreenDaftarDr
import com.example.appslifebloodid.model.dataArtikel
import com.example.appslifebloodid.ui.page.AboutScreen
import com.example.appslifebloodid.page.Component.NavigateScreen.KebijakanPrivasi
import com.example.appslifebloodid.page.Component.NavigateScreen.KetentuanPengguna
import com.example.appslifebloodid.page.Component.NavigateScreen.Pertanyaan
import com.example.appslifebloodid.page.Component.NavigateScreen.PusatBantuan
import com.example.appslifebloodid.page.Component.NavigateScreen.TentangAplikasi
import com.example.appslifebloodid.ui.page.EventScreen
import com.example.appslifebloodid.ui.page.HomeScreen
import com.example.appslifebloodid.ui.page.RiwayatScreen
import com.example.appslifebloodid.route.RouteBotNav
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.LihatSemua
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.PendaftaranEvent

@RequiresApi(Build.VERSION_CODES.O)
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
            EventScreen(navController = navController)
        }
        composable(route = RouteBotNav.About.route) {
            AboutScreen(navController = navController)
        }

        // New Screen About
        composable(route = "TentangAplikasi") {
            TentangAplikasi(navController = navController)
        }
        composable(route = "Kebijakan&Privasi") {
            KebijakanPrivasi(navController = navController)
        }
        composable(route = "PusatBantuan") {
            PusatBantuan(navController = navController)
        }
        composable(route = "KetentuanPengguna") {
            KetentuanPengguna(navController = navController)
        }
        composable(route = "PertanyaanYangSeringDitanyakan") {
            Pertanyaan(navController = navController)
        }

        //ScreenMenuHome
        composable(route = "ScreenReward") {
            ScreenReward(navController = navController)
        }
        composable(route = "ScreenChat") {
            ScreenChat(navController = navController)
        }
        composable(route = "ScreenDaftarDr") {
            ScreenDaftarDr(navController = navController)
        }
        composable(route = "ScreenStockDarah") {
            ScreenStockDarah(navController = navController)
        }
        composable(route = "ScreenJadwalDonor") {
            ScreenJadwalDonor(navController = navController)
        }
        composable(route = "ScreenChat") {
            ScreenChat(navController = navController)
        }
        composable(
            route = "DetailArtikel/{artikelId}",
            arguments = listOf(navArgument("artikelId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            DetailArtikel(
                navController = navController,
                artikelId = navBackStackEntry.arguments?.getInt("artikelId")
            )
        }
        composable(
            route = "DetailEvent/{eventId}",
            arguments = listOf(navArgument("eventId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            DetailEvent(
                navController = navController,
                eventId = navBackStackEntry.arguments?.getInt("eventId")
            )
        }
        composable(route = "PendaftaranEvent") {
            PendaftaranEvent(navController = navController)
        }
        composable(route = "LihatSemua") {
            LihatSemua(navController = navController)
        }

    }
}