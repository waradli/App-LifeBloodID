package com.example.appslifebloodid.ui.intro.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.response.Article

@Composable
fun ArtikelItem(article: Article, navController: NavController) {
    val imageUrl = RetrofitInstance.baseUrl + article.image_url

    println("Image URL: $imageUrl")

    Card(
        modifier = Modifier.padding(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = "News",
                modifier = Modifier
                    .width(120.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = article.title,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                    )
                )
                Text(
                    text = article.content,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                    )
                )
                Text(
                    text = article.created_at,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xff959595)
                    )
                )
                Box(modifier = Modifier.padding(start = 80.dp, top = 20.dp)) {
                    Button(
                        onClick = { navController.navigate("DetailArtikel/${article.id}") },
                        shape = RoundedCornerShape(13.dp),
                        modifier = Modifier
                            .width(130.dp)
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffB20909))
                    ) {
                        Text(
                            text = "Baca Artikel", style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
            }
        }
    }
}