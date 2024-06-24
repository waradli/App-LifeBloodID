package com.example.appslifebloodid.ui.page.component.item_navbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appslifebloodid.R
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.repository.ArticleRepository
import com.example.appslifebloodid.ui.base.ArticleViewModel
import com.example.appslifebloodid.ui.base.AuthViewModel
import com.example.appslifebloodid.ui.page.component.baca_artikel.ArtikelItem
import com.example.appslifebloodid.ui.base.ArticleViewModelFactory

@Composable
fun Item_Home(navController: NavController, authViewModel: AuthViewModel) {
    val repository = ArticleRepository(RetrofitInstance.api)
    val viewModel: ArticleViewModel = viewModel(
        factory = ArticleViewModelFactory(repository)
    )
    val articles by viewModel.articles.observeAsState(emptyList())
    val username = authViewModel.getUsername()

    Column(
        Modifier
            .padding(vertical = 2.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#ececec"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout {
            val (topImg, profile, item) = createRefs()
            Image(painterResource(id = R.drawable.bg_homee), null,
                Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })
            Column(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .constrainAs(profile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_profile),
                        contentDescription = "Image Profile",
                        modifier = Modifier
                            .size(90.dp)
                            .padding(start = 30.dp, top = 20.dp)
                            .clickable {
                                navController.navigate("ScreenProfile")
                            }
                    )
                    Column(
                        modifier = Modifier
                            .padding(
                                top = 30.dp, start = 15.dp
                            )
                    ) {
                        Text(
                            text = "Selamat Datang",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.White,
                            )
                        )
                        Text(
                            text = username ?: "Tidak ada nama",
                            style = TextStyle(
                                fontSize = 15.sp,
                                color = Color.White,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notif",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(vertical = 30.dp, horizontal = 60.dp)
                            .size(width = 40.dp, height = 40.dp)
                            .clickable {
                                navController.navigate("ScreenNotif")
                            }
                    )
                }
                Spacer(modifier = Modifier.height(17.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* Change listener for search query */ },
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                    },
                    modifier = Modifier
                        .width(350.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors()

                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .constrainAs(item) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                        .height(70.dp)
                        .width(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.jadwal),
                        contentDescription = null,
                        Modifier
                            .size(52.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .clickable { navController.navigate("ScreenDonor") }
                    )
                    Text(
                        text = "Jadwal Donor",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Color(android.graphics.Color.parseColor("#000000"))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                        .height(70.dp)
                        .width(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stock_darah),
                        contentDescription = null,
                        Modifier
                            .size(52.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .clickable { navController.navigate("ScreenStockDarah") }
                    )
                    Text(
                        text = "Stock Darah",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Color(android.graphics.Color.parseColor("#000000"))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                        .height(70.dp)
                        .width(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = null,
                        Modifier
                            .size(52.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .clickable { navController.navigate("ScreenDaftarDr") }
                    )
                    Text(
                        text = "Chat",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Color(android.graphics.Color.parseColor("#000000"))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .height(70.dp)
                        .width(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.reward),
                        contentDescription = null,
                        Modifier
                            .size(53.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .clickable { navController.navigate("ScreenReward") }
                    )
                    Text(
                        text = "Reward",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Color(android.graphics.Color.parseColor("#000000"))
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Artikel Donor Darah",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Box(
            ) {
                Text(
                    text = "lihat semua",
                    modifier = Modifier.clickable { navController.navigate("LihatSemua") },
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light, color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
        ) {
            items(
                items = articles,
                itemContent = { art -> ArtikelItem(art, navController) }
            )
        }
    }
}