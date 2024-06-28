package com.example.disneyapp.data.remote.network


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("allies")
    val allies: List<String?>? = listOf(),
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("enemies")
    val enemies: List<String?>? = listOf(),
    @SerializedName("films")
    val films: List<String?>? = listOf(),
    @SerializedName("_id")
    val id: Int? = 0,
    @SerializedName("imageUrl")
    val imageUrl: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("parkAttractions")
    val parkAttractions: List<String?>? = listOf(),
    @SerializedName("shortFilms")
    val shortFilms: List<String?>? = listOf(),
    @SerializedName("sourceUrl")
    val sourceUrl: String? = "",
    @SerializedName("tvShows")
    val tvShows: List<String?>? = listOf(),
    @SerializedName("updatedAt")
    val updatedAt: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("__v")
    val v: Int? = 0,
    @SerializedName("videoGames")
    val videoGames: List<String?>? = listOf()
)