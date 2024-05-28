package com.example.appslifebloodid.page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.appslifebloodid.page.component.item_navbar.Item_Home

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Item_Home(navController)
    }
}