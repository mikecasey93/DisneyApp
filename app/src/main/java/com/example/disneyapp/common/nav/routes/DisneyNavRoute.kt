package com.example.disneyapp.common.nav.routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson

sealed class DisneyNavRoute(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    data object Details : DisneyNavRoute(
        route = "$ROUTE_DISNEY_DETAILS/{$ARG_DISNEY_INFO}",
        arguments = listOf(
            navArgument(ARG_DISNEY_INFO) {
                type = NavType.StringType
            }
        )
    ) {
        fun routeForDisney(input: DisneyInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_DISNEY_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): DisneyInput {
            val json = entry.arguments?.getString(ARG_DISNEY_INFO) ?: ""
            return DisneyInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_DISNEY_DETAILS = "disneyDetails"
        const val ARG_DISNEY_INFO = "disneyInfo"
    }
}

data class DisneyInput(
    val name: String?,
    val image: String?,
    val sourceUrl: String?,
    val updatedAt: String?
) {

    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): DisneyInput {
            return Gson().fromJson(json, DisneyInput::class.java)
        }
    }
}