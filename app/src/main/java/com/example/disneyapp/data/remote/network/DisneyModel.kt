package com.example.disneyapp.data.remote.network


import com.google.gson.annotations.SerializedName

data class DisneyModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("info")
    val info: InfoModel? = InfoModel()
)