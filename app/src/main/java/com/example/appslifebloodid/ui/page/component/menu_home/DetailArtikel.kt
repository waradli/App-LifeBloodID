package com.example.appslifebloodid.ui.page.component.menu_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appslifebloodid.data.response.Article

@Composable
fun DetailArtikel(
    modifier: Modifier = Modifier,
    navController: NavController,
    artikelId: Int?,
) {
    Column {
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
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "Detail Artikel",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White
                )
            }
        }
//        LazyColumn {
//            val detailArt = DataColumn.artikelColum.filter { dataArtikel ->
//                dataArtikel.id == artikelId
//            }
//
//            item {
//
//                Column(
//                    modifier = modifier
//                ) {
//                    PrevDetailArt(detailArt = detailArt)
//                }
//            }
//        }


    }
}

@Composable
fun PrevDetailArt(
    modifier: Modifier = Modifier,
    detailArt: List<Article>,
) {
    Column(

        modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
    ) {
        Text(
            text = detailArt[0].title,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        Card(elevation = CardDefaults.cardElevation(10.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = detailArt[0].image_url)
                    .build(),
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth(),


                contentDescription = "Poster Movie"
            )
        }
        Spacer(
            modifier =
            Modifier.padding(vertical = 20.dp)

        )
        Text(
            text = "${detailArt[0].created_at}",
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color(0xff959595)
            )
        )
    }


}

