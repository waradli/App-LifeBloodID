package com.example.appslifebloodid.ui.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appslifebloodid.route.BotNavBar
import com.example.appslifebloodid.ui.intro.FirstScreen
import com.example.appslifebloodid.ui.intro.onboarding.OnBoardingScreen
import com.example.appslifebloodid.ui.intro.LoginScreen
import com.example.appslifebloodid.ui.intro.RegisterScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AuthNavHost(navController: NavHostController, startDestination: String, authViewModel: AuthViewModel) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("onBoardingScreen") {
            OnBoardingScreen(navController = navController)
        }
        composable("loginScreen") {
            FirstScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(authViewModel, navController)
        }
        composable("register") {
            RegisterScreen(authViewModel, navController)
        }
        composable("home") {
            BotNavBar(authViewModel = authViewModel)
        }
    }
}