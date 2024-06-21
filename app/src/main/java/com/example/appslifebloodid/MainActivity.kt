package com.example.appslifebloodid

import android.os.Build
import android.os.Bundle
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
import com.example.appslifebloodid.ui.page.component.item_navbar.Item_Home

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthRepository())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AuthNavHost(navController, authViewModel)
        }
    }
}

class AuthViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}
