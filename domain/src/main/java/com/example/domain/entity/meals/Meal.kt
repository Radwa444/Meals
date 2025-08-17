package com.example.domain.entity.meals

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Meal(
    val idMeal: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strInstructions: String?,
    val strArea: String?,
    val strYoutube: String?
) : Parcelable
