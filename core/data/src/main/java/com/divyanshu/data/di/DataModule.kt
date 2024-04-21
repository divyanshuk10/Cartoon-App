package com.divyanshu.data.di

import com.divyanshu.data.repository.CartoonsRepository
import com.divyanshu.data.repository.NetworkCartoonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsTopicRepository(
        topicsRepository: NetworkCartoonRepository,
    ): CartoonsRepository

}