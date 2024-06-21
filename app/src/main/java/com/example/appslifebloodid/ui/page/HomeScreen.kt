package com.example.appslifebloodid.ui.page

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appslifebloodid.ui.page.component.item_navbar.Item_Home

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Item_Home(navController = navController)
    }
}