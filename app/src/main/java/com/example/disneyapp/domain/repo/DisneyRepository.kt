package com.example.disneyapp.domain.repo

import com.example.disneyapp.data.remote.network.DisneyModel
import com.example.disneyapp.domain.entity.CharacterObj
import kotlinx.coroutines.flow.Flow

interface DisneyRepository {

    fun getCharacters(): Flow<DisneyModel?>

    fun getCharacter(charId: String?): Flow<CharacterObj>
}