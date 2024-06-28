package com.example.disneyapp.domain.usecase

import android.content.res.Configuration
import com.example.disneyapp.data.remote.network.DisneyModel
import com.example.disneyapp.domain.repo.DisneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCharacterUseCase(
    configuration: Configuration,
    private val repo: DisneyRepository
) : UseCase<GetCharacterUseCase.Request, GetCharacterUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getCharacters().map {
            Response(it)
        }

    data object Request : UseCase.Request

    data class Response(val characters: DisneyModel?) : UseCase.Response
}