package com.example.disneyapp.data.remote.source

import com.example.disneyapp.data.remote.endpoints.DisneyEndpoints
import com.example.disneyapp.data.remote.network.DataModel
import com.example.disneyapp.data.remote.network.DisneyModel
import com.example.disneyapp.data.remote.network.InfoModel
import com.example.disneyapp.data.remote.repository.RemoteDisneyDataSource
import com.example.disneyapp.domain.entity.CharacterObj
import com.example.disneyapp.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteDisneyDataSourceImpl @Inject constructor(
    private val service: DisneyEndpoints
): RemoteDisneyDataSource {

    override fun getCharacters(): Flow<DisneyModel?> = flow {
        val characters = service.getCharacters()
        emit(characters)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getCharacter(charId: String?): Flow<CharacterObj> = flow {
        emit(service.getCharacter(charId))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: DataModel?) =
        CharacterObj(
            model?.name,
            model?.imageUrl,
            model?.sourceUrl,
            model?.updatedAt
        )
}