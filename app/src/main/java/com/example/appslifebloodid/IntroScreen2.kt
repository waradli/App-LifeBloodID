package com.example.appslifebloodid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IntroScreen2(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier.fillMaxSize().background(Color(0xFFF6F6))
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.imgint2),
                contentDescription = "logo intro2"
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "    Mulailah perjalanan kebaikanmu\n" + "dengan satu tetes darah yang berarti \n" + "   bagi mereka yang membutuhkan",
                fontSize = 18.sp, fontWeight = FontWeight.Bold
            )
        }
    }


}