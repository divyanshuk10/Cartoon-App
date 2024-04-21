package com.divyanshu.assignmentapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.divyanshu.data.repository.NetworkCartoonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val cartoonsRepository: NetworkCartoonRepository) :
    ViewModel() {
    val cartoonListData = Pager(PagingConfig(pageSize = 1)) {
        cartoonsRepository
    }.flow.cachedIn(viewModelScope)

}