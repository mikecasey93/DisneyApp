package com.example.disneyapp.app.converters

import android.content.Context
import com.example.disneyapp.app.model.Disney
import com.example.disneyapp.app.model.DisneyListModel
import com.example.disneyapp.common.state.CommonResultConverter
import com.example.disneyapp.domain.usecase.GetCharacterUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DisneyListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetCharacterUseCase.Response, DisneyListModel>() {

    override fun convertSuccess(
        data: GetCharacterUseCase.Response
    ) : DisneyListModel {
        return DisneyListModel(
            characters = data.characters?.data?.map {
                Disney(
                    name = it?.name,
                    image = it?.imageUrl,
                    sourceUrl = it?.sourceUrl,
                    updatedAt = it?.updatedAt
                )
            } ?: listOf()
        )
    }
}