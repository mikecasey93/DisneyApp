package com.example.disneyapp.data.remote.di

import coil.decode.DataSource
import com.example.disneyapp.data.remote.repository.RemoteDisneyDataSource
import com.example.disneyapp.data.remote.source.RemoteDisneyDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindDisneyInfoDataSource(dataSource: RemoteDisneyDataSourceImpl): RemoteDisneyDataSource
}