package com.divyanshu.network.retrofit

import com.divyanshu.common.Constants
import com.divyanshu.model.Cartoon
import com.divyanshu.network.NetworkDataSource
import kotlinx.serialization.Serializable
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface CartoonApiService {

    @GET("character/")
    suspend fun getCartoons(@Query("page") page: Int): Response<Cartoon>
}

@Serializable
private data class NetworkResponse<T>(
    val data: T,
)

@Singleton
internal class RetrofitCartoonNetwork @Inject constructor(
    okHttpClient: OkHttpClient,
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(CartoonApiService::class.java)

    override suspend fun getCartoons(page: Int): Response<Cartoon> =
        networkApi.getCartoons(page)


}