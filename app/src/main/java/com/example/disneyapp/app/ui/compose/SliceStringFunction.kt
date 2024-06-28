package com.example.disneyapp.app.ui.compose

object SliceStringFunction {

    fun cutString(str: String?): String? {
        return str?.slice(0..9)
    }
}