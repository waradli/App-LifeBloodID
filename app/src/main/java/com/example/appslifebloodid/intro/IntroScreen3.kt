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
fun IntroScreen3(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier.fillMaxSize().background(Color(0xFF1F1F1))

    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.intro3),
                contentDescription = "jpg intro3"
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "              Satu langkah kecil untukmu,\n" +
                    "          satu harapan besar bagi yang lain.\n" +
                    "Mari bersama-sama menjadikan setiap detik \n" +
                    "         berharga dalam memberi kehidupan.", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        }
    }


}