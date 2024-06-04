package com.example.appslifebloodid.page

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.appslifebloodid.page.Component.Item.Item_Event

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EventScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Item_Event(navController = navController)
}