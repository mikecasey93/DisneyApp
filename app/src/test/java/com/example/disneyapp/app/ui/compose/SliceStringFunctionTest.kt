package com.example.disneyapp.app.ui.compose

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.Assert.*

class SliceStringFunctionTest {

    @Test
    fun `is string ten characters`() {
        val result = SliceStringFunction.cutString("aaaaaaaaaa")
        assertThat(result).hasLength(10)
    }

    @Test
    fun `contains two dashes`() {
        val result = SliceStringFunction.cutString("2021-12-20")
        assertEquals(2, result?.count { it == '-' })
    }

    fun String.noLetters() = all { !it.isLetter() }

    @Test
    fun `contains no letters`() {
        val result = SliceStringFunction.cutString("2021-12-20")
        assertThat(result?.noLetters())
    }

    @Test
    fun `index four and seven are dash`() {
        val result = SliceStringFunction.cutString("2021-12-20")
        assertThat(result?.get(4) == '-' && result.get(7) == '-')
    }
}