package com.example.appslifebloodid.Intro.onboarding

import androidx.annotation.DrawableRes
import com.example.appslifebloodid.R

data class Page(
    val description: String,
    @DrawableRes val image: Int,
    val imageSizeFraction: Float
)


val pages = listOf(
    Page(
        description = "Selamat datang di Lifeblood ID",
        image = R.drawable.intro1,
        imageSizeFraction = 0.55f
    ),
    Page(
        description = "Mulailah perjalanan kebaikanmu dengan satu tetes darah yang berarti bagi mereka yang membutuhkan.",
        image = R.drawable.intro2,
        imageSizeFraction = 0.55f
    ),
    Page(
        description = "Satu langkah kecil untukmu, satu harapan besar bagi yang lain. Mari bersama-sama menjadikan setiap detik berharga dalam memberi kehidupan.",
        image = R.drawable.intro3,
        imageSizeFraction = 0.52f
    )
)