package com.example.appslifebloodid.Page.Component.NavigateScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pertanyaan(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xffE1DDDD),
        topBar = {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xffE35A5A)),
                    title = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "Pertanyaan Yang Sering Ditanyakan?",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                ),
                            )
                        }

                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        }
    ) { PaddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(PaddingValues)
                .fillMaxSize()
                .height(800.dp)
                .background(Color(0xffF6F6F6)),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                ItemPertanyaan()
            }
        }
    }
}

@Composable
fun ItemPertanyaan(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
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
            modifier = Modifier.padding(start = 10.dp, end = 3.dp, top = 20.dp),
            text = "1.Bagaimana cara mendaftar sebagai pendonor di LifebloodId? ",
            style = TextStyle(
                fontSize = 12.sp,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Untuk mendaftar sebagai pendonor di LifebloodId, buka aplikasi dan ikuti langkah-langkah pendaftaran yang disediakan. Isi informasi pribadi Anda dengan akurat dan lengkap.",
            style = TextStyle(
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 3.dp, top = 20.dp),
            text = "2.Bagaimana cara mencari lokasi donor darah terdekat?",
            style = TextStyle(
                fontSize = 12.sp,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Di dalam aplikasi LifebloodId, Anda dapat menggunakan fitur \"Cari Lokasi Donor Darah\" untuk menemukan lokasi donor darah yang terdekat berdasarkan lokasi Anda saat ini atau lokasi yang dipilih.",
            style = TextStyle(
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 3.dp, top = 20.dp),
            text = "3.Bagaimana cara melihat jadwal donor darah di LifebloodId? ",
            style = TextStyle(
                fontSize = 12.sp,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Di dalam aplikasi LifebloodId, navigasikan ke menu \"Jadwal Donor Darah\" untuk melihat acara donor darah yang terjadwal. Anda dapat mendaftar untuk berpartisipasi dalam acara tertentu.",
            style = TextStyle(
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 3.dp, top = 20.dp),
            text = "4.Bagaimana cara melihat riwayat donor darah saya?",
            style = TextStyle(
                fontSize = 12.sp,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Anda dapat melihat riwayat donor darah Anda dengan masuk ke menu \"Riwayat Donor\" di dalam aplikasi LifebloodId. Riwayat ini mencakup jumlah donasi, jenis darah yang didonasikan, dan tanggal donor terakhir.",
            style = TextStyle(
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
            ),
        )

    }
}