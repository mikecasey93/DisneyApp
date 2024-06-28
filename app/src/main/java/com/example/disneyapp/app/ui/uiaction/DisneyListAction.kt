package com.example.disneyapp.app.ui.uiaction

import com.example.disneyapp.common.state.UiAction

sealed class DisneyListAction: UiAction {

    data object Load : DisneyListAction()

    data class DisneyItemClick(
        val name: String?,
        val image: String?,
        val sourceUrl: String?,
        val updatedAt: String?
    ) : DisneyListAction()
}