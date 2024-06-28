package com.example.disneyapp.app.di.usecase

import com.example.disneyapp.domain.repo.DisneyRepository
import com.example.disneyapp.domain.usecase.GetCharacterByIdUseCase
import com.example.disneyapp.domain.usecase.GetCharacterUseCase
import com.example.disneyapp.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DisneyUseCaseModule {

    @Provides
    fun provideGetDisneyUseCase(
        configuration: UseCase.Configuration,
        repository: DisneyRepository
    ): GetCharacterUseCase = GetCharacterUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetCharacterByIdUseCase(
        configuration: UseCase.Configuration,
        repository: DisneyRepository
    ): GetCharacterByIdUseCase = GetCharacterByIdUseCase(
        configuration,
        repository
    )
}