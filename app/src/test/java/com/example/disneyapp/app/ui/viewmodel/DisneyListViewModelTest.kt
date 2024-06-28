package com.example.disneyapp.app.ui.viewmodel

import com.example.disneyapp.app.converters.DisneyListConverter
import com.example.disneyapp.app.ui.uiaction.DisneyListAction
import com.example.disneyapp.app.ui.uiaction.DisneyListSingleEvent
import com.example.disneyapp.common.nav.routes.DisneyInput
import com.example.disneyapp.common.nav.routes.DisneyNavRoute
import com.example.disneyapp.domain.usecase.GetCharacterUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class DisneyListViewModelTest {

    private lateinit var viewModel: DisneyListViewModel
    private lateinit var useCase: GetCharacterUseCase
    private lateinit var converter: DisneyListConverter
    private val dispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        useCase = mockk()
        converter = mockk()
        viewModel = DisneyListViewModel(useCase, converter)
    }

    @Test
    fun testDisneyItemClick() = runBlocking {
        val testAction = DisneyListAction.DisneyItemClick(
            name = "Achilles",
            image = "https://static.wikia.nocookie.net/disney/images/d/d3/Vlcsnap-2015-05-06-23h04m15s601.png",
            sourceUrl = "https://disney.fandom.com/wiki/Achilles_(Hercules)",
            updatedAt = "2021-12-20T20:39:18.033Z"
        )

        viewModel.handleAction(testAction)

        val result = DisneyListSingleEvent.GoToDetailsScreen(
            DisneyNavRoute.Details.routeForDisney(
                DisneyInput(
                    name = testAction.name,
                    image = testAction.image,
                    sourceUrl = testAction.sourceUrl,
                    updatedAt = testAction.updatedAt
                )
            )
        )

        assertEquals(result, viewModel.singleEventFlow.first())
    }
}