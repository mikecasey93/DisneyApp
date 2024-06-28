package com.example.disneyapp.app.model

data class DisneyListModel (
    val characters: List<Disney> = listOf()
)

data class Disney(
    val name: String? = "",
    val image: String? = "",
    val sourceUrl: String? = "",
    val updatedAt: String? = ""
)
