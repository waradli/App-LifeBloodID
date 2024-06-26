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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.repository.ArticleRepository
import com.example.appslifebloodid.data.repository.EventRepository
import com.example.appslifebloodid.data.response.Article
import com.example.appslifebloodid.ui.base.ArticleViewModel
import com.example.appslifebloodid.ui.base.ArticleViewModelFactory
import com.example.appslifebloodid.ui.base.EventViewModel
import com.example.appslifebloodid.ui.base.EventViewModelFactory

@Composable
fun DetailArtikel(
    navController: NavController,
    artikelId: Int,
//    locationId: Int,
    viewModel: ArticleViewModel = viewModel(
        factory = ArticleViewModelFactory(ArticleRepository(RetrofitInstance.api))
    )
) {
    val articleDetail by viewModel.articleDetail.collectAsState()

    // Fetch location detail when the composable is first launched
    LaunchedEffect(artikelId) {
        viewModel.getLocationDetail(artikelId)
    }
    articleDetail?.let { article ->
        val imageUrl = RetrofitInstance.baseUrl + article.image_url
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(top = 40.dp)
                    .background(Color(0xffb20909))
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
                            modifier = Modifier.size(30.dp),
                            contentDescription = "Icon Arrow"
                        )
                    }
                    Spacer(modifier = Modifier.width(100.dp))
                    Text(
                        text = "Detail Artikel",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 10.dp),
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = article.title,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(vertical = 20.dp))
                Card(elevation = CardDefaults.cardElevation(10.dp)) {

                    Image(
                        painter = rememberImagePainter(
                            data = imageUrl,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .width(400.dp)
                            .height(300.dp)
                    )
                }
                Spacer(
                    modifier =
                    Modifier.padding(vertical = 20.dp)

                )
                Text(
                    text = "12 Maret 2024",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,

                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = article.content,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,

                    )
                )
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
}

//@Composable
//fun PrevDetailArt(
//    modifier: Modifier = Modifier,
//    detailArt: List<Article>,
//) {
//    Column(
//
//        modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
//    ) {
//        Text(
//            text = detailArt[0].title,
//            fontSize = 23.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Spacer(modifier = Modifier.padding(vertical = 20.dp))
//        Card(elevation = CardDefaults.cardElevation(10.dp)) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(data = detailArt[0].image_url)
//                    .build(),
//                contentScale = ContentScale.Fit,
//                modifier = Modifier.fillMaxWidth(),
//
//
//                contentDescription = "Poster Movie"
//            )
//        }
//        Spacer(
//            modifier =
//            Modifier.padding(vertical = 20.dp)
//
//        )
//        Text(
//            text = "${detailArt[0].created_at}",
//            style = TextStyle(
//                fontWeight = FontWeight.Medium,
//                fontSize = 14.sp,
//                color = Color(0xff959595)
//            )
//        )
//    }
//
//
//}
//
