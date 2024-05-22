package com.example.appslifebloodid.Page.Component.Item


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.R


@Composable
fun Item_Riwayat(
    modifier: Modifier = Modifier,
) {
    Column {
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
                            painter = painterResource(id = R.drawable.pngwing),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(text = "ID   001234")
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
                            text = "A",
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
                            painter = painterResource(id = R.drawable.qr_code),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(
                            text = "21,Maret,2024",
                            style = TextStyle(
                                Color(0xffD2D2D2),
                                fontSize = 12.sp,
                            )
                        )
                    }
                }
            }
        }
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
                            painter = painterResource(id = R.drawable.pngwing),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(text = "ID   001234")
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
                            text = "A",
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
                            painter = painterResource(id = R.drawable.qr_code),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(
                            text = "21,Maret,2024",
                            style = TextStyle(
                                Color(0xffD2D2D2),
                                fontSize = 12.sp,
                            )
                        )
                    }
                }
            }
        }
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
                            painter = painterResource(id = R.drawable.pngwing),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(text = "ID   001234")
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
                            text = "A",
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
                            painter = painterResource(id = R.drawable.qr_code),
                            modifier = Modifier.size(115.dp),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Image Riwayat"
                        )
                        Text(
                            text = "21,Maret,2024",
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