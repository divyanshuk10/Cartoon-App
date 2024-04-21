package com.divyanshu.data.repository

import com.divyanshu.model.Cartoon
import com.divyanshu.network.NetworkDataSource
import retrofit2.Response
import javax.inject.Inject

class NetworkCartoonRepository @Inject constructor(private val network: NetworkDataSource) :
    CartoonsRepository {

    override suspend fun getCartoons(page: Int): Response<Cartoon> =
        network.getCartoons(page)

}