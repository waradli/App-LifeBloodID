package com.app_donor_darah.Route

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appslifebloodid.route.RouteBotNav

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BotNavBar(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        BottomGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Composable
fun BottomBar(
    navController: NavHostController,
) {
    val Screens = listOf(
        RouteBotNav.Home,
        RouteBotNav.Riwayat,
        RouteBotNav.Event,
        RouteBotNav.About,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 50.dp,)
            .background(Color(0xFFE35A5A), shape = RoundedCornerShape(30))
            .height(58.dp)
            .fillMaxWidth(),


        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Screens.forEach { Screens ->
            AddItem(
                Screens = Screens,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    Screens: RouteBotNav,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any() { it.route == Screens.route } == true
    val contentColor = if (selected) Color(0xFFb20909) else Color(
        0xffF1F1F1
    )
    val background = if (selected) Color(
        0xffF1F1F1
    ).copy(alpha = 1f) else Color.Transparent
    Box(
        modifier = Modifier
            .height(45.dp)
            .padding(start = 17.dp, end = 17.dp)
            .background(background, shape = RoundedCornerShape(30))
            .clickable(onClick = {
                navController.navigate(Screens.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                    restoreState = true

                }
            })
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = if (selected) Screens.focused else Screens.icon),
                contentDescription = "icon",
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = Screens.title, style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    ), color = contentColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BotNavBarPrev() {
    BotNavBar()
}