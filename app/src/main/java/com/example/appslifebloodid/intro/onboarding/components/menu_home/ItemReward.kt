package com.example.appslifebloodid.intro.onboarding.components.menu_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.model.dataReward

@Composable
fun ItemReward(modifier: Modifier = Modifier,
               reward: dataReward) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .width(340.dp)
                .height(80.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ){
            Row {
                Image(painter = painterResource(id = reward.photo) ,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(95.dp)
                        .height(80.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(10.dp)))
                Spacer(modifier = Modifier.width(10.dp))
                Column (modifier = Modifier.padding(top = 10.dp)){
                    Text(text = reward.jenis_promo, fontWeight = FontWeight.Bold,fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = reward.promo,fontWeight = FontWeight.Bold)
                }
                Column (modifier = Modifier.padding(start = 30.dp)){
                    Button(onClick = { /*TODO*/ }, modifier = Modifier
                        .width(80.dp)
                        .height(100.dp), shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(Color(0xFFE35A5A))) {
                        Text(text = "Tukar", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    }
                }

            }

        }
    }
}