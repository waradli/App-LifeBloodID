package com.example.appslifebloodid.page.Component.NavigateScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PusatBantuan(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(vertical = 40.dp)) {
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
                Text(
                    text = "Pusat Bantuan",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 80.dp)
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .height(800.dp)
                .background(Color(0xffF6F6F6)),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                ItemPusatBantuan()
            }
        }
    }
}

@Composable
fun ItemPusatBantuan(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding()
            .fillMaxWidth()
            .background(
                Color(
                    0xFFF6F6
                )
            )
    ) {
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "Jika Anda memiliki pertanyaan atau membutuhkan bantuan lebih lanjut, jangan ragu untuk menghubungi tim dukungan LifebloodId: ",
            style = TextStyle(
                fontSize = 15.sp,
            ),
        )
        Spacer(modifier = modifier.padding(bottom = 20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 30.dp)
        ) {
            Canvas(
                modifier = Modifier.size(6.dp)
            ) {
                drawCircle(color = Color.Black)
            }
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Email: support@lifebloodid.com",
                style = TextStyle(
                    fontSize = 15.sp,
                )
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.padding(vertical = 8.dp, horizontal = 30.dp)
        ) {
            Canvas(
                modifier = Modifier.size(6.dp)
            ) {
                drawCircle(color = Color.Black)
            }
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Telepon: +628123456789",
                style = TextStyle(
                    fontSize = 15.sp,
                )
            )
        }
        Spacer(modifier = modifier.padding(bottom = 40.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp),
            style = TextStyle(
                fontSize = 15.sp,
            ),
            text = "Tim dukungan kami siap membantu Anda dengan segala pertanyaan atau masalah yang Anda hadapi saat menggunakan LifebloodId. Kami berkomitmen untuk mendukung kegiatan donor darah dan memastikan pengalaman pengguna yang positif dalam menyelamatkan nyawa."
        )
        Spacer(modifier = modifier.padding(bottom = 40.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp),
            style = TextStyle(
                fontSize = 15.sp,
            ),
            text = "Terima kasih atas partisipasi Anda dalam mendukung kegiatan donor darah melalui LifebloodId!"
        )
    }
}