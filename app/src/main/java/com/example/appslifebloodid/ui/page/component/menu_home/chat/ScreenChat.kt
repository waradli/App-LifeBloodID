package com.example.appslifebloodid.ui.page.component.menu_home.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R

@Composable
fun ScreenChat(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 35.dp)
                .background(Color(0xffE35A5A))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        tint = Color.White,
                        modifier = Modifier.size(50.dp),
                        contentDescription = "Icon Arrow"
                    )
                }
                Column(modifier = Modifier.padding(top = 10.dp)) {
                    Card(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_profile),
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Dokter Ali",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(modifier = Modifier.padding(top = 2.dp)) {
                        Card(
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .width(8.dp)
                                .height(8.dp),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Online", fontSize = 15.sp, color = Color.White)
                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier
            .padding(start = 150.dp)
            .width(230.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xffE35A5A))) {
            Column(modifier = Modifier.padding(all = 10.dp)) {
                Text(text = "Halo Selamat Pagi dok, Saya Izin Bertanya mengenai donor darah", fontSize = 18.sp, color = Color.White)
                Row(modifier = Modifier.padding(start = 130.dp)) {
                    Text(text = "10.13", color = Color.White)
                    Spacer(modifier = Modifier.width(3.dp))
                    Image(painter = painterResource(id = R.drawable.iconread), contentDescription = null, modifier = Modifier.size(30.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier
            .padding(start = 10.dp)
            .width(230.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xffE35A5A))) {
            Column(modifier = Modifier.padding(all = 10.dp)) {
                Text(text = "Selamat Pagi, Ada yang bisa saya bantu ?", fontSize = 18.sp, color = Color.White)
                Row(modifier = Modifier.padding(start = 150.dp)) {
                    Text(text = "10.13", color = Color.White)
                    Spacer(modifier = Modifier.width(3.dp))
                }
            }
        }
        Column(modifier = Modifier.padding(start = 180.dp)) {
            Image(
                painter = painterResource(id = R.drawable.keluhan),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )
        }
        Box(modifier = Modifier
            .padding(start = 150.dp)
            .width(230.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xffE35A5A))) {
            Column(modifier = Modifier.padding(all = 10.dp)) {
                Text(text = "Ini saya sampai kapan disuntik pak?", fontSize = 18.sp, color = Color.White)
                Row(modifier = Modifier.padding(start = 130.dp)) {
                    Text(text = "10.13", color = Color.White)
                    Spacer(modifier = Modifier.width(3.dp))
                    Image(painter = painterResource(id = R.drawable.iconread), contentDescription = null, modifier = Modifier.size(30.dp))
                }
            }
        }
    }
}