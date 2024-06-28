package com.example.disneyapp.common.nav

import androidx.navigation.NamedNavArgument
import com.example.disneyapp.common.nav.routes.DisneyNavRoute

sealed class NavRoutes(
    val routes: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    data object Home : NavRoutes(ROUTE_HOME)

    object Disney : NavRoutes(DisneyNavRoute.Details.route, DisneyNavRoute.Details.arguments)

    companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_DISNEY = "disney"
    }
}