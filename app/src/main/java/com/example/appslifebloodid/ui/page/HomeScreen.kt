package com.example.appslifebloodid.ui.page


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.base.AuthViewModel
import com.example.appslifebloodid.ui.page.component.item_navbar.Item_Home

@Composable
fun HomeScreen(navController: NavController, authViewModel: AuthViewModel) {
    Column {
        Item_Home(navController = navController, authViewModel)
    }
}