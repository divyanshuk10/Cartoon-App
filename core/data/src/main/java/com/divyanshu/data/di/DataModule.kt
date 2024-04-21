package com.divyanshu.data.di

import com.divyanshu.data.repository.NetworkCartoonRepository
import com.divyanshu.network.NetworkDataSource
import com.divyanshu.network.retrofit.RetrofitCartoonNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesNetworkDataSource(okHttpClient: OkHttpClient): NetworkDataSource =
        RetrofitCartoonNetwork(okHttpClient)

    @Provides
    fun providesNetworkRepository(
        networkDataSource: NetworkDataSource,
    ): NetworkCartoonRepository = NetworkCartoonRepository(networkDataSource)


}