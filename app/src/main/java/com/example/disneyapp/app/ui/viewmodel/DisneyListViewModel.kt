package com.example.disneyapp.app.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.disneyapp.app.converters.DisneyListConverter
import com.example.disneyapp.app.model.DisneyListModel
import com.example.disneyapp.app.ui.uiaction.DisneyListAction
import com.example.disneyapp.app.ui.uiaction.DisneyListSingleEvent
import com.example.disneyapp.common.nav.routes.DisneyInput
import com.example.disneyapp.common.nav.routes.DisneyNavRoute
import com.example.disneyapp.common.state.MviViewModel
import com.example.disneyapp.common.state.UiState
import com.example.disneyapp.domain.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisneyListViewModel @Inject constructor(
    private val useCase: GetCharacterUseCase,
    private val converter: DisneyListConverter
): MviViewModel<DisneyListModel, UiState<DisneyListModel>, DisneyListAction, DisneyListSingleEvent>() {

    override fun initState(): UiState<DisneyListModel> = UiState.Loading

    override fun handleAction(action: DisneyListAction) {
        when (action) {
            is DisneyListAction.Load -> {
                loadCharacters()
            }
            is DisneyListAction.DisneyItemClick -> {
                submitSingleEvent(
                    DisneyListSingleEvent.GoToDetailsScreen(
                        DisneyNavRoute.Details.routeForDisney(
                            DisneyInput(
                                action.name,
                                action.image,
                                action.sourceUrl,
                                action.updatedAt
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            useCase.execute(GetCharacterUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect{
                    submitState(it)
                }
        }
    }
}