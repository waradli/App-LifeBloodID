package com.example.appslifebloodid

import android.app.Application
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.appslifebloodid.data.repository.AuthRepository
import com.example.appslifebloodid.ui.base.AuthNavHost
import com.example.appslifebloodid.ui.base.AuthViewModel

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(application, AuthRepository())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val startDestination = if (authViewModel.isUserLoggedIn()) "home" else "onBoardingScreen"
            AuthNavHost(navController = navController, startDestination = startDestination, authViewModel = authViewModel)
        }

        if (authViewModel.isUserLoggedIn()) {
            val loggedInUser = authViewModel.getUsername()
            if (loggedInUser != null) {
                Log.d("AuthStatus", "User $loggedInUser is logged in")
            } else {
                Log.d("AuthStatus", "Unable to retrieve logged in user")
            }
        } else {
            Log.d("AuthStatus", "User is not logged in")
        }
    }
}

class AuthViewModelFactory(private val application: Application, private val repository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(application, repository) as T
    }
}
