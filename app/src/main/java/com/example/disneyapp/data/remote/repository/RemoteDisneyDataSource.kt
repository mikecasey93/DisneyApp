package com.example.disneyapp.data.remote.repository

import com.example.disneyapp.data.remote.network.DisneyModel
import com.example.disneyapp.domain.entity.CharacterObj
import kotlinx.coroutines.flow.Flow

interface RemoteDisneyDataSource {

    fun getCharacters(): Flow<DisneyModel?>

    fun getCharacter(charId: String?): Flow<CharacterObj>
}