package com.example.appslifebloodid.ui.page.component.menu_home.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R
import com.example.appslifebloodid.model.dataDokter

@Composable
fun ItemDokter(
    modifier: Modifier = Modifier,
    dtDokter: dataDokter,
    navController: NavController
) {
    Column(modifier = modifier.padding(top = 15.dp)) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .width(320.dp)
                .height(150.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Column(modifier = Modifier) {
                Row(modifier = Modifier.padding(top = 10.dp)) {
                    Column(modifier = Modifier.padding(top = 10.dp, start = 20.dp)) {
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
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = dtDokter.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    thickness = 1.dp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.padding(start = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = dtDokter.rating)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = dtDokter.masakerja)
                    Spacer(modifier = Modifier.width(40.dp))
                    Button(
                        onClick = { navController.navigate("ScreenChat") },
                        modifier = Modifier.width(100.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffb20909))
                    ) {
                        Text(text = "Chat", fontSize = 18.sp)
                    }
                }
            }
        }
    }
}