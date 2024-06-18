package com.example.appslifebloodid.page.Component.Item


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Item_About(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xfffffff).copy(alpha = 1f))
                .height(400.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 2.dp,
                ),

            ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Tentang Aplikasi",
                        style = TextStyle(
                            fontSize = 18.sp,

                            ),
                        modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                    )
                    IconButton(
                        onClick = {
                            navController.navigate("TentangAplikasi")
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Icon Arrow"
                        )
                    }
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp)

                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Kebijakan & Privasi",
                        style = TextStyle(
                            fontSize = 18.sp,
                        ),
                        modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                    )
                    IconButton(
                        onClick = { navController.navigate("Kebijakan&Privasi") },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Icon Arrow"
                        )
                    }
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp)

                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Pusat Bantuan",
                        style = TextStyle(
                            fontSize = 18.sp,
                        ),
                        modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                    )
                    IconButton(
                        onClick = { navController.navigate("PusatBantuan") },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Icon Arrow"
                        )
                    }
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 10.dp, end = 2.dp)

                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Ketentuan Pengguna",
                        style = TextStyle(
                            fontSize = 18.sp,
                        ),
                        modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                    )
                    IconButton(
                        onClick = { navController.navigate("KetentuanPengguna") },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Icon Arrow"
                        )
                    }
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp)

                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Pertanyaan yang Sering Ditanyakan?",
                        style = TextStyle(
                            fontSize = 18.sp,
                        ),
                        modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                    )
                    IconButton(
                        onClick = { navController.navigate("PertanyaanYangSeringDitanyakan") },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Icon Arrow"
                        )
                    }
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp)

                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(top = 80.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xfffB20909))
        ) {
            Text(
                text = "KELUAR",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            )
        }
    }

}