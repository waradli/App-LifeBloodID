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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.page.component.event.GridItem
import com.example.appslifebloodid.ui.intro.onboarding.components.ImageSliderEvent
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.repository.EventRepository
import com.example.appslifebloodid.ui.base.EventViewModel
import com.example.appslifebloodid.ui.base.EventViewModelFactory

@Composable
fun Item_Event(navController: NavController) {
    val repository = EventRepository(RetrofitInstance.api)
    val viewModel: EventViewModel = viewModel(
        factory = EventViewModelFactory(repository)
    )

    val locations by viewModel.locations.observeAsState(emptyList())

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 40.dp),
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
    Spacer(modifier = Modifier.height(15.dp))
        LazyVerticalGrid(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            columns = GridCells.Adaptive(140.dp),

            ) {
            items(
                items = locations,
                itemContent = { art -> GridItem(art, navController) }
            )
        }
    }
}

