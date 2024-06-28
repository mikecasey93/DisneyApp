package com.example.disneyapp.app.ui.uiaction

import org.junit.Assert.*
import org.junit.Test

class DisneyListSingleEventTest {

    @Test
    fun `test navigate to DisneyDetailsScreen`() {
        val navRoute = "character/112"
        val uiEvent = DisneyListSingleEvent.GoToDetailsScreen(navRoute)

        assertEquals(navRoute, uiEvent.route)
        assertTrue(uiEvent is DisneyListSingleEvent.GoToDetailsScreen)
    }
}