package com.example.appslifebloodid.ui.intro.onboarding.components.menu_home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appslifebloodid.data.DataColumn
import com.example.appslifebloodid.ui.intro.onboarding.components.ArtikelItem

@Composable
fun LihatSemua(modifier: Modifier = Modifier,
               navController: NavController) {
    Column (modifier = Modifier,
    ){
        val lhtArtikel = remember { DataColumn.artikelLhtsemua }
        LazyColumn(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
        ) {
            items(
                items = lhtArtikel,
                itemContent = { Itemlihatsemua(lhtartikel = it,navController = navController) })
        }
    }
}