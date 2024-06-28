package com.example.disneyapp.app.ui.uiaction

import org.junit.Assert.*
import org.junit.Test

class DisneyListActionTest {

    @Test
    fun `test DisneyItemClick Action`() {
        val name: String = "Achilles"
        val image: String = "https://static.wikia.nocookie.net/disney/images/d/d3/Vlcsnap-2015-05-06-23h04m15s601.png"
        val sourceUrl: String = "https://disney.fandom.com/wiki/Achilles_(Hercules)"
        val updatedAt: String = "2021-12-20T20:39:18.033Z"

        val action = DisneyListAction.DisneyItemClick(
            name = name,
            image = image,
            sourceUrl = sourceUrl,
            updatedAt =updatedAt
        )

        assertTrue(action is DisneyListAction.DisneyItemClick)
        assertEquals(name, action.name)
        assertEquals(image, action.image)
        assertEquals(sourceUrl, action.sourceUrl)
        assertEquals(updatedAt, action.updatedAt)
    }
}