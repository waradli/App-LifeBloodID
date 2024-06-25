package com.example.appslifebloodid.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.data.DataRiwayat
import com.example.appslifebloodid.model.Model_Riwayat
import com.example.appslifebloodid.page.Component.Item.Item_Riwayat
import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatScreen(
    modifier: Modifier = Modifier,
    riwayatt: List<Model_Riwayat> = DataRiwayat.KumpulanRiwayat
) {
    Column(
        modifier = Modifier.padding(vertical = 40.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xffb20909))
            , contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Riwayat",
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
        ) {
            items(riwayatt, key = { it.id }) {
                Item_Riwayat(riwayats = it)
            }
        }
    }
}