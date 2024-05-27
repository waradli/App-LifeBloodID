package com.example.appslifebloodid.route

import com.example.appslifebloodid.R

sealed class RouteBotNav(
    val route: String,
    val title: String,
    val icon: Int,
    val focused: Int,
) {
    // Route Home
    object Home : RouteBotNav(
        route = "Home",
        title = "Home",
        icon = R.drawable.ic_home,
        focused = R.drawable.ic_home_focus
    )

    // Route Riwayat
    object Riwayat : RouteBotNav(
        route = "Riwayat",
        title = "Riwayat",
        icon = R.drawable.ic_riwayat,
        focused = R.drawable.ic_riwayat_focus
    )

    // Route Event
    object Event : RouteBotNav(
        route = "Event",
        title = "Event",
        icon = R.drawable.ic_event,
        focused = R.drawable.ic_event_focus
    )

    // Route About
    object About : RouteBotNav(
        route = "About",
        title = "About",
        icon = R.drawable.ic_about,
        focused = R.drawable.ic_about_focus
    )
}