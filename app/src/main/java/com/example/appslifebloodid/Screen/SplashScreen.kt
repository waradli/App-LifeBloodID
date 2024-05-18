package com.example.appslifebloodid.Screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appslifebloodid.R

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val gerak = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        gerak.animateTo(
            targetValue = 1f,
            animationSpec = tween(1500)
        )
    }
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF6F6)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        )
        Image(
            modifier = Modifier.alpha(gerak.value)
                .size(350.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
    }

}