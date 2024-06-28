package com.example.disneyapp.data.remote.network


import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("nextPage")
    val nextPage: String? = "",
    @SerializedName("previousPage")
    val previousPage: String? = String(),
    @SerializedName("totalPages")
    val totalPages: Int? = 0
)