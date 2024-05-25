package com.example.appslifebloodid.page

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appslifebloodid.page.component.item.Item_Home

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column {
        Item_Home()
    }
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//    ) {
//        items(1) { index ->
//
//        }
//    }
}