package com.app_donor_darah.Screen.Component

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Item_About(
    modifier: Modifier = Modifier
) {
    Column(

        modifier = Modifier
            .fillMaxHeight()

    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xfffffff).copy(alpha = 1f))
                .height(400.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 2.dp,
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Tentang Aplikasi",
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                )
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Icon",
                    modifier = Modifier.padding(start = 15.dp, top = 14.dp)

                )
            }
        }
    }


}