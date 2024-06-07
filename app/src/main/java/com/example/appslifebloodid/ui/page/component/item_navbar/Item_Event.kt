package com.example.appslifebloodid.page.Component.Item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.intro.onboarding.components.GridItem
import com.example.appslifebloodid.ui.intro.onboarding.components.ImageSliderEvent
import com.example.appslifebloodid.data.DataGrid
import com.example.appslifebloodid.model.dataEvent

@Composable
fun Item_Event(modifier: Modifier = Modifier,
               navController: NavController,
               grids: List<dataEvent> = DataGrid.GridEvent
              ) {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageSliderEvent()
        Spacer(modifier = Modifier.height(15.dp))
        Box (modifier = Modifier){
            OutlinedTextField(
                value = "",
                onValueChange = { /* Change listener for search query */ },
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                },
                modifier = Modifier
                    .width(330.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors()
            )
        }

        LazyVerticalGrid(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Adaptive(140.dp),

            ) {
            items(grids, key = {it.id}){
                GridItem(grids = it, navController = navController)
            }
        }


    }
}

