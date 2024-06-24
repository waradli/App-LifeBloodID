package com.example.appslifebloodid.ui.intro.onboarding.components.menu_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R

@Composable
fun RincianDaftar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 25.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                tint = Color.Black,
                modifier = Modifier.size(width = 30.dp, height = 30.dp),
                contentDescription = "Icon Arrow"
            )
        }
        Card(
            modifier = modifier
                .padding(16.dp)
                .width(350.dp)
                .height(350.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column {
                Row {
                    Box(modifier = Modifier.padding(all = 20.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.img_profile),
                            contentDescription = "profil",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(text = "Ali Wardana", fontSize = 18.sp)
                        Divider(
                            modifier = Modifier.width(200.dp),
                            thickness = 1.dp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "00123", fontSize = 18.sp)
                        Divider(
                            modifier = Modifier.width(200.dp),
                            thickness = 1.dp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Laki - Laki", fontSize = 18.sp)
                        Divider(
                            modifier = Modifier.width(200.dp),
                            thickness = 1.dp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "22 Maret 2024", fontSize = 18.sp)
                        Divider(
                            modifier = Modifier.width(200.dp),
                            thickness = 1.dp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Jl. Hayam Muruk, No.5", fontSize = 18.sp)
                        Divider(
                            modifier = Modifier.width(200.dp),
                            thickness = 1.dp,
                            color = Color.Black
                        )
                    }

                }
                Spacer(modifier = Modifier.height(15.dp))
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Color.Black
                )
                Row {
                    Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                        Text(
                            text = "Golongan Darah :",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "A",
                            fontSize = 150.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 30.dp)
                        )
                    }
                    Divider(
                        thickness = 1.dp, color = Color.Black, modifier = Modifier
                            .padding(start = 55.dp)
                            .size(width = 1.dp, height = 200.dp)
                            .graphicsLayer(rotationZ = 180f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.barcode),

                        contentDescription = "barcode",
                        modifier = Modifier
                            .padding(20.dp)
                            .size(150.dp)
                    )
                }
            }
        }
    }
}