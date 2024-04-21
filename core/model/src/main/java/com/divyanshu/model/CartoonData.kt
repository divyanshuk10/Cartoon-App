package com.divyanshu.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartoonData(
    val gender: String,
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val type: String,
) : Parcelable