package com.divyanshu.network

import com.divyanshu.model.Cartoon
import retrofit2.Response

interface NetworkDataSource {
    suspend fun getCartoons(page: Int): Response<Cartoon>
}