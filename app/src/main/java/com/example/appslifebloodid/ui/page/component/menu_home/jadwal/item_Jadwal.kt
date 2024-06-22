package com.example.appslifebloodid.ui.page.component.menu_home.jadwal

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.ui.page.component.menu_home.jadwal.model.jadwal
import com.example.appslifebloodid.ui.theme.poppinsFontFamily


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ItemJadwal(
    modifier: Modifier = Modifier,
    jadwall: jadwal
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 10.dp)
//                .background(Color.DarkGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Text(
                        text = jadwall.jam,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    )
                    Box(
                        modifier = Modifier.padding(horizontal = 20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "icon lainnya",
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }
                Text(
                    text = jadwall.desc, style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,

                        )
                )
                Text(
                    text = jadwall.tanggal, style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                )
            }

        }
    }
}
