package com.example.appslifebloodid.ui.page.component.menu_home

import android.widget.Space
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenStockDarah(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column {
       Box (
           modifier = Modifier
               .fillMaxWidth()
               .height(100.dp)
               .padding(top = 35.dp)
               .background(Color(0xffE35A5A))
       ){
           Row (
               modifier = Modifier.fillMaxWidth(),
               verticalAlignment = Alignment.CenterVertically
           ){
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
               Spacer(modifier = Modifier.width(120.dp))
               Text(
                   text = "Stock Darah",
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Bold,
                   modifier = Modifier.padding(top = 10.dp),
                   color = Color.White
               )
           }
       }
        Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp)
        ) {
            Text(text = "Lokasi Stock Darah", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* Change listener for search query */ },
                    placeholder = { Text(text = "Cari Lokasi")},
                    modifier = Modifier
                        .width(260.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors()
                )
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { /*TODO*/ }, modifier = Modifier.width(80.dp).height(50.dp), shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(Color(0xffE35A5A))
                ) {
                    Text(text = "Cari",fontSize = 20.sp)
                }
            }

        }
    }
}