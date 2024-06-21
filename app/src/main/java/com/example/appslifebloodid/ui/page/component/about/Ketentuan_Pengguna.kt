package com.example.appslifebloodid.page.Component.NavigateScreen

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
fun KetentuanPengguna(
    navController: NavController,
    modifier: Modifier = Modifier
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
                Text(
                    text = "Ketentuan Pengguna",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 50.dp)
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
                ItemKetentuanPengguna()
            }
        }
    }

}

@Composable
fun ItemKetentuanPengguna(
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
            text = "Selamat datang di LifebloodId! Sebelum menggunakan aplikasi ini,harap baca dan pahami ketentuan pengguna di bawah ini: ",
            style = TextStyle(
                fontSize = 12.sp,
            ),
        )
        Spacer(modifier = modifier.padding(bottom = 10.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "1. Pendaftaran Pendonor",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "Untuk menjadi pendonor darah di LifebloodId, Anda harus mendaftar dan memberikan informasi yang akurat tentang diri Anda.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "Pastikan informasi yang Anda berikan termasuk golongan darah, riwayat kesehatan, dan kontak yang dapat dihubungi adalah benar dan terkini.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )
        Spacer(modifier = modifier.padding(bottom = 10.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "2. Jadwal Donor Darah",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "LifebloodId menyediakan jadwal donor darah yang terorganisir oleh pihak ketiga. Kami tidak bertanggung jawab atas perubahan jadwal atau acara yang tidak terkait dengan layanan kami.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "Peserta diharapkan untuk mematuhi protokol dan persyaratan yang ditetapkan oleh penyelenggara acara donor darah.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )
        Spacer(modifier = modifier.padding(bottom = 10.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "3. Pencarian Lokasi Donor Darah",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "Informasi mengenai lokasi donor darah yang tersedia di LifebloodId disediakan sebagai referensi. Kami tidak menjamin ketersediaan stok darah di setiap lokasi setiap saat.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "Pastikan untuk memeriksa informasi kontak dan waktu operasional yang tercantum sebelum mengunjungi lokasi donor darah.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )
        Spacer(modifier = modifier.padding(bottom = 10.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp, end = 3.dp, top = 20.dp),
            text = "4. Perubahan Ketentuan",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "Kami berhak untuk mengubah atau memperbarui ketentuan pengguna ini dari waktu ke waktu. Perubahan akan diinformasikan kepada pengguna melalui aplikasi atau situs web kami.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 3.dp, top = 20.dp),
            text = "Dengan melanjutkan penggunaan LifebloodId setelah perubahan ini, Anda dianggap menyetujui ketentuan terbaru yang berlaku.",
            style = TextStyle(
                fontSize = 12.sp,
            )
        )


    }
}