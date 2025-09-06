package com.sajib.media365.di

import com.sajib.media365.data.network.MyApi
import com.sajib.media365.data.repo.Repo
import com.sajib.media365.data.repo.RepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    fun provideMyApiRepo(myApi: MyApi) : Repo = RepoImpl(myApi = myApi)
}