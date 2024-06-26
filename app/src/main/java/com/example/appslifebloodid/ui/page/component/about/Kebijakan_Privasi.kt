package com.example.appslifebloodid.page.Component.NavigateScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KebijakanPrivasi(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(vertical = 40.dp)
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
                Text(
                    text = "Kebijakan & Privasi",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 60.dp)
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
                ItemTentangAplikasi()
            }
        }
    }

}

@Composable
fun ItemTentangAplikasi(
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
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "1. Pengumpulan Informasi ",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Aplikasi Donor Darah XYZ dapat mengumpulkan informasi pribadi seperti nama, alamat, nomor telepon, tanggal lahir, golongan darah,telepon, tanggal lahir, golongan darah, dan riwayat donor darah untuk keperluan administrasi dan logistik\n",
            style = TextStyle(
                fontSize = 15.sp,
                textAlign = TextAlign.Justify,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "2.  Tujuan Pengumpulan",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Informasi yang dikumpulkan digunakan untuk memfasilitasi proses pendaftaran donor darah,mengatur jadwal donor darah, dan menghubungkan donor dengan penerima darah yang membutuhkan\n",
            style = TextStyle(
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "3.   Penggunaan Informasi",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Informasi pribadi yang dikumpulkan hanya digunakan untuk keperluan internal aplikasi,seperti manajemen akun pengguna dan komunikasi terkait donor darah.\n",
            style = TextStyle(
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
            ),
        )
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "4.  Kerahasiaan dan Keamanan",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
            text = "Kami mengambil tindakan keamanan yang tepat untuk melindungi informasi pribadi pengguna dari akses, penggunaan, atau pengungkapan yang tidak sah.\n",
            style = TextStyle(
                fontSize = 12.sp,
                textAlign = TextAlign.Justify,
            ),
        )
    }}