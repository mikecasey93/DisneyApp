package com.example.disneyapp.app.di

import com.example.disneyapp.data.remote.repository.DisneyRepositoryImpl
import com.example.disneyapp.data.remote.repository.RemoteDisneyDataSource
import com.example.disneyapp.domain.repo.DisneyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesDisneyRepository(
        remoteSource: RemoteDisneyDataSource,
    ): DisneyRepository = DisneyRepositoryImpl(
        remoteSource
    )

}