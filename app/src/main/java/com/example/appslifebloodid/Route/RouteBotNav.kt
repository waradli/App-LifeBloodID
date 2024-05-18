package com.app_donor_darah.Route


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
        icon = R.drawable.baseline_home_24,
        focused = R.drawable.baseline_home_focus24
    )

    // Route Riwayat
    object Riwayat : RouteBotNav(
        route = "Riwayat",
        title = "Riwayat",
        icon = R.drawable.baseline_history_edu_24,
        focused = R.drawable.baseline_history_edu_focus24
    )

    // Route Event
    object Event : RouteBotNav(
        route = "Event",
        title = "Event",
        icon = R.drawable.baseline_event_available_24,
        focused = R.drawable.baseline_event_available_focus24
    )

    // Route About
    object About : RouteBotNav(
        route = "About",
        title = "About",
        icon = R.drawable.baseline_info_outline_24,
        focused = R.drawable.baseline_info_outline_focus24
    )
}