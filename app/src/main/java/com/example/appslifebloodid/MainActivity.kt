package com.example.appslifebloodid

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app_donor_darah.Route.BotNavBar
import com.example.appslifebloodid.data.repository.AuthRepository
import com.example.appslifebloodid.ui.base.AuthNavHost
import com.example.appslifebloodid.ui.base.AuthViewModel
import com.example.appslifebloodid.ui.intro.LoginScreen
import com.example.appslifebloodid.ui.intro.onboarding.OnBoardingScreen
import com.example.appslifebloodid.ui.screen.ScreenDaftar
import com.example.appslifebloodid.ui.screen.ScreenMasuk
import com.example.appslifebloodid.ui.theme.AppsLifeBloodIDTheme

class MainActivity : ComponentActivity() {
//    private val authViewModel: AuthViewModel by viewModels {
//        AuthViewModelFactory(AuthRepository())
//    }

    @RequiresApi(Build.VERSION_CODES.O)
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
        }
//            val navController = rememberNavController()
//            AuthNavHost(navController, authViewModel)
        }
    }

//class AuthViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return AuthViewModel(repository) as T
//    }
//}
