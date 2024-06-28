package com.example.disneyapp.app.ui.uiaction

import com.example.disneyapp.common.state.UiSingleEvent

sealed class DisneyListSingleEvent: UiSingleEvent {

    data class GoToDetailsScreen(val route: String): DisneyListSingleEvent()
}