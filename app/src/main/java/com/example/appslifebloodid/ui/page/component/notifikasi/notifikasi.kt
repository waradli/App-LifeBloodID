package com.example.appslifebloodid.ui.page.component.notifikasi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.page.component.notifikasi.data.dataa
import com.example.appslifebloodid.ui.page.component.notifikasi.model.notif
import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@Composable
fun ScreenNotifikasi(
    modifier: Modifier = Modifier,
    navController: NavController,
    notifikasi: List<notif> = dataa.listNotifikasi,
) {
    Column(
        modifier = Modifier.padding(vertical = 45.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xffb20909))
                .padding(vertical = 15.dp, horizontal = 20.dp),

            ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "icon back",
                    modifier = Modifier
                        .size(45.dp, 45.dp)
                        .clickable {
                            navController.popBackStack()
                        }, tint = Color.White
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "Notifikasi",
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn {
            items(notifikasi, key = { it.id }) {
                ItemNotifikasi(notifikasi = it)
            }
        }
    }

}