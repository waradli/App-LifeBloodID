package com.example.appslifebloodid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app_donor_darah.Route.BotNavBar
import com.example.appslifebloodid.intro.LoginScreen
import com.example.appslifebloodid.intro.onboarding.OnBoardingScreen
import com.example.appslifebloodid.screen.ScreenDaftar
import com.example.appslifebloodid.screen.ScreenMasuk
import com.example.appslifebloodid.ui.theme.AppsLifeBloodIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppsLifeBloodIDTheme{
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    NavHost(navController = navController, startDestination = "onBoardingScreen") {
                        composable("onBoardingScreen") {
                            OnBoardingScreen(navController = navController)
                        }
                        composable("loginScreen") {
                            LoginScreen(navController = navController)
                        }
                        composable("masuk") {
                            ScreenMasuk(navController = navController)
                        }
                        composable("daftar") {
                            ScreenDaftar(navController = navController)
                        }
                        composable("home") {
                            BotNavBar()
                        }
                    }

                }
            }
//            IntroLogin()
//            ScreenMasuk()
//            BotNavBar()
//            ScreenDaftar()
//            SplashScreen()
//            IntroScreen1()
//            IntroScreen2()
//            IntroScreen3()
        }
    }
}
