package com.example.appslifebloodid.page.Component.Item


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.R
import com.example.appslifebloodid.data.DataRiwayat
import com.example.appslifebloodid.model.Model_Riwayat


@Composable
fun Item_Riwayat(
    modifier: Modifier = Modifier,
    riwayats : Model_Riwayat

) {
    Column (modifier = Modifier
        .background(color = Color(android.graphics.Color.parseColor("#f1f1f1f1")))){
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                .size(width = 450.dp, height = 150.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                Color(0xffFFFFFF)
            ),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = riwayats.image),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(text = "ID  ${riwayats.noId}" )
                    }
                }
                Divider(
                    thickness = 1.dp, color = Color.Black, modifier = Modifier
                        .size(width = 2.dp, height = 200.dp)
                        .graphicsLayer(rotationZ = 180f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(120.dp)

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Text(
                            text = "${riwayats.darah}",
                            style = TextStyle(fontSize = 70.sp),
                        )

                    }
                }
                Divider(
                    thickness = 1.dp, color = Color.Black, modifier = Modifier
                        .size(width = 2.dp, height = 200.dp)
                        .graphicsLayer(rotationZ = 180f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(5.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = riwayats.imageScan),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(
                            text = riwayats.tanggal,
                            style = TextStyle(
                                Color(0xffD2D2D2),
                                fontSize = 12.sp,
                            )
                        )
                    }
                }
            }
        }
    }
}