package com.example.appslifebloodid.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.data.DataRiwayat
import com.example.appslifebloodid.model.Model_Riwayat
import com.example.appslifebloodid.page.Component.Item.Item_Riwayat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatScreen(
    modifier: Modifier = Modifier,
    riwayatt: List<Model_Riwayat> = DataRiwayat.KumpulanRiwayat
) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xffE1DDDD),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xffE35A5A)),
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Riwayat",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                            ),
                        )
                    }
                },
            )

        }
    ) { PaddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(PaddingValues)
        ) {
            items(riwayatt, key = { it.id }) {
                Item_Riwayat(riwayats = it)
            }
        }
    }
}