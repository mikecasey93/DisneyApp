package com.example.disneyapp.domain.usecase

import android.content.res.Configuration
import com.example.disneyapp.domain.entity.CharacterObj
import com.example.disneyapp.domain.repo.DisneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCharacterByIdUseCase(
    configuration: Configuration,
    private val repo: DisneyRepository
) : UseCase<GetCharacterByIdUseCase.Request, GetCharacterByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getCharacter(request.charId).map {
            Response(it)
        }

    data class Request(val charId: String?) : UseCase.Request

    data class Response(val charId: CharacterObj?) : UseCase.Response
}