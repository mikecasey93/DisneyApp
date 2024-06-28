package com.example.disneyapp.data.remote.repository

import com.example.disneyapp.data.remote.endpoints.DisneyEndpoints
import com.example.disneyapp.data.remote.network.DisneyModel
import com.example.disneyapp.domain.entity.CharacterObj
import com.example.disneyapp.domain.entity.UseCaseException
import com.example.disneyapp.domain.repo.DisneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DisneyRepositoryImpl(
    private val remoteSource: RemoteDisneyDataSource
) : DisneyRepository {

    override fun getCharacters(): Flow<DisneyModel?> {
        return remoteSource.getCharacters()
    }

    override fun getCharacter(charId: String?): Flow<CharacterObj> {
       return remoteSource.getCharacter(charId)
    }
}