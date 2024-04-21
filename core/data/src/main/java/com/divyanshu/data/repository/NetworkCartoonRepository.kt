package com.divyanshu.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.divyanshu.model.Cartoon
import com.divyanshu.model.CartoonData
import com.divyanshu.network.NetworkDataSource
import retrofit2.Response
import javax.inject.Inject

class NetworkCartoonRepository @Inject constructor(private val network: NetworkDataSource) :
    PagingSource<Int, CartoonData>() {

    private suspend fun getCartoons(page: Int): Response<Cartoon> =
        network.getCartoons(page)

    suspend fun searchCartoonCharacters(name: String): Response<Cartoon> =
        network.searchCartoonCharacters(name)

    override fun getRefreshKey(state: PagingState<Int, CartoonData>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CartoonData> {
        return try {
            val currentPage = params.key ?: 1
            val response = getCartoons(currentPage)
            val data = response.body()
            val responseListData = data?.results ?: emptyList()

            LoadResult.Page(
                data = responseListData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}