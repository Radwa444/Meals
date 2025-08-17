package com.example.domain.entity.Category

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
): Parcelable