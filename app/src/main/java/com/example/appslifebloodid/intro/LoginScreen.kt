package com.example.appslifebloodid.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier.fillMaxSize().background(Color(0xFFF6F6))
    ){
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo", modifier = Modifier.size(350.dp))

            Text(text = "Welcome to LifeBloodID", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "         Apakah Anda ingin bantuan untuk\n" +
                    " kesehatan Darah Anda untuk mendapatkan\n" +
                    "              kehidupan yang lebih baik?")
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = { navController.navigate("masuk") },
                    modifier = Modifier
                    .width(320.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB20909))
            ) {
                Text(text = "Masuk", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "atau")
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { navController.navigate("daftar") },
                modifier = Modifier
                    .width(320.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB20909))
                ) {
                Text(text = "Daftar", fontSize = 18.sp)
            }
        }
    }

}