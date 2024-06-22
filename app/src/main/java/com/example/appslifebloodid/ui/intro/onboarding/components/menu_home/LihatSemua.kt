package com.example.appslifebloodid.ui.intro.onboarding.components.menu_home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.repository.ArticleRepository
import com.example.appslifebloodid.ui.base.ArticleViewModel
import com.example.appslifebloodid.ui.base.ArticleViewModelFactory
import com.example.appslifebloodid.ui.intro.onboarding.components.ArtikelItem

import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@Composable
fun LihatSemua(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(vertical = 50.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xffb20909)),

            ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Icon Arrow",
                    modifier = Modifier
                        .size(width = 30.dp, height = 30.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                    tint = Color.White
                )
                Text(text = "Artikel", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(start = 130.dp))
            }
        }
        val repository = ArticleRepository(RetrofitInstance.api)
        val viewModel: ArticleViewModel = viewModel(
            factory = ArticleViewModelFactory(repository)
        )
        val articles by viewModel.articles.observeAsState(emptyList())
        LazyColumn(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
        ) {
            items(
                items = articles,
                itemContent = { art -> ArtikelItem(art, navController) }
            )
        }
    }
}