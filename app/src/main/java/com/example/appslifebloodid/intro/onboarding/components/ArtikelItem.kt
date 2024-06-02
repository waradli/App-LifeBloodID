package com.example.appslifebloodid.intro.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.data.DataColumn
import com.example.appslifebloodid.model.dataArtikel

@Composable
fun ArtikelItem(
    modifier: Modifier = Modifier,
    Artikel: dataArtikel,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .width(340.dp)
            .height(150.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )

    ) {
        Row {
            ArtikelImage(Artikel = Artikel)
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.padding(top = 5.dp)
            ) {

                Text(text = Artikel.title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = Artikel.date)
                Spacer(modifier = Modifier.height(30.dp))
                Row(modifier = Modifier.padding(start = 120.dp)) {
                    Text(
                        text = "Baca Artikel",
                        modifier = Modifier.clickable { navController.navigate("DetailArtikel") },
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Red
                    )
                }
            }
        }
    }
}

@Composable
fun ArtikelImage(
    modifier: Modifier = Modifier,
    Artikel: dataArtikel
) {
    Image(
        painter = painterResource(id = Artikel.photo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(125.dp)
            .height(150.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
    )

}