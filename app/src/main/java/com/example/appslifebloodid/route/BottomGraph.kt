package com.example.appslifebloodid.route

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appslifebloodid.ui.page.AboutScreen
import com.example.appslifebloodid.page.Component.NavigateScreen.KebijakanPrivasi
import com.example.appslifebloodid.page.Component.NavigateScreen.KetentuanPengguna
import com.example.appslifebloodid.page.Component.NavigateScreen.Pertanyaan
import com.example.appslifebloodid.page.Component.NavigateScreen.PusatBantuan
import com.example.appslifebloodid.page.Component.NavigateScreen.TentangAplikasi
import com.example.appslifebloodid.ui.page.EventScreen
import com.example.appslifebloodid.ui.page.RiwayatScreen
import com.example.appslifebloodid.ui.base.AuthViewModel
import com.example.appslifebloodid.ui.base.EventRegistrationViewModel
import com.example.appslifebloodid.ui.intro.FirstScreen
import com.example.appslifebloodid.ui.page.component.lihat_semua.LihatSemua
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.PendaftaranEvent
import com.example.appslifebloodid.ui.intro.onboarding.components.menu_home.RincianDaftar
import com.example.appslifebloodid.ui.page.HomeScreen
import com.example.appslifebloodid.ui.page.component.baca_artikel.DetailArtikel
import com.example.appslifebloodid.ui.page.component.event.DetailEvent
import com.example.appslifebloodid.ui.page.component.menu_home.reward.ScreenReward
import com.example.appslifebloodid.ui.page.component.menu_home.stock_darah.ScreenStockDarah
import com.example.appslifebloodid.ui.page.component.menu_home.chat.ScreenChat
import com.example.appslifebloodid.ui.page.component.menu_home.chat.ScreenDaftarDr
import com.example.appslifebloodid.ui.page.component.menu_home.jadwal.ScreenJadwalDonor
import com.example.appslifebloodid.ui.page.component.menu_home.notifikasi.ScreenNotifikasi
import com.example.appslifebloodid.ui.page.component.menu_home.profile.ProfileScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    modifier: Modifier = Modifier,
) {
    lateinit var eventRegistrationViewModel: EventRegistrationViewModel
    NavHost(navController = navController, startDestination = RouteBotNav.Home.route) {
        composable(route = RouteBotNav.Home.route) {
            HomeScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(route = RouteBotNav.Riwayat.route) {
            RiwayatScreen()
        }
        composable(route = RouteBotNav.Event.route) {
            EventScreen(navController = navController)
        }
        composable(route = RouteBotNav.About.route) {
            AboutScreen(navController = navController, authViewModel = authViewModel)
        }

        composable("loginScreen") { FirstScreen(navController = navController) }

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
            ScreenChat(navController = navController, username = "")
        }
        composable(route = "ScreenDaftarDr") {
            ScreenDaftarDr(navController = navController)
        }
        composable(route = "ScreenStockDarah") {
            ScreenStockDarah(navController = navController)
        }
        composable(route = "ScreenDonor") {
            ScreenJadwalDonor(navController = navController)
        }
        composable(route = "ScreenProfile") {
            ProfileScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(route = "ScreenNotif") {
            ScreenNotifikasi(navController=navController)
        }
        composable(route = "LihatSemua") {
            LihatSemua(navController = navController)
        }


        // Event
        composable(route = "PendaftaranEvent") {
            PendaftaranEvent(navController = navController  )
        }
        
        //rincian daftar
        composable(route = "RincianDaftar"){
            RincianDaftar(navController = navController)
        }

        composable(
            route = "DetailArtikel/{artikelId}",
            arguments = listOf(navArgument("artikelId") { type = NavType.IntType })
        ) { backStackEntry ->
            val artikelId = backStackEntry.arguments?.getInt("artikelId") ?: 0
            DetailArtikel(navController = navController, artikelId = artikelId)
        }
        composable(
            route = "DetailEvent/{locationId}",
            arguments = listOf(navArgument("locationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getInt("locationId") ?: 0
            DetailEvent(navController = navController, locationId = locationId)
        }
    }
}