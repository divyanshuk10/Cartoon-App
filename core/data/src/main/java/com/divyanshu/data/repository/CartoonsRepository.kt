package com.divyanshu.data.repository

import com.divyanshu.model.Cartoon
import retrofit2.Response

interface CartoonsRepository {

    suspend fun getCartoons(page: Int): Response<Cartoon>
}