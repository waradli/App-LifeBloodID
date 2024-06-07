package com.example.appslifebloodid.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R


@Composable
fun LoginScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .background(Color(0xFFF1F1F1)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(450.dp))
        }
        Text(text = "Selamat Datang Di LifeBloodID", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "         Apakah Anda ingin bantuan untuk\n" +
                " kesehatan Darah Anda untuk mendapatkan\n" +
                "              kehidupan yang lebih baik?", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.navigate("masuk") },
            modifier = Modifier
                .width(365.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB20909)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Masuk", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .width(150.dp)
                .height(1.dp)
                .background(Color.Gray))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Atau")
            Spacer(modifier = Modifier.width(10.dp))
            Box(modifier = Modifier
                .width(150.dp)
                .height(1.dp)
                .background(Color.Gray))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = { navController.navigate("daftar") },
            modifier = Modifier
                .width(365.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB20909)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Daftar", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(150.dp))
    }
}