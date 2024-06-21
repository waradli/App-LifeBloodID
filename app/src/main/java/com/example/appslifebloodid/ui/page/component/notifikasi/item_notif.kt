package com.example.appslifebloodid.ui.page.component.notifikasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.ui.page.component.notifikasi.model.notif
import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@Composable
fun ItemNotifikasi(
    notifikasi: notif,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(Color(0xffF1F1F1).copy(alpha = 1f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(vertical = 15.dp, horizontal = 8.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = notifikasi.img),
                    contentDescription = "icon event",
                    modifier = Modifier.size(30.dp, 25.dp)
                )
                Column {
                    Text(
                        text = notifikasi.judul,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = poppinsFontFamily
                        )
                    )
                    Text(
                        text = notifikasi.desc,
                        style = TextStyle(
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = poppinsFontFamily
                        )
                    )
                }
                Text(
                    text = notifikasi.minute,
                    style = TextStyle(
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = poppinsFontFamily,
                        color = Color.Gray
                    ),
                )
            }
        }
    }
}