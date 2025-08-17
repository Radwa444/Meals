package com.example.data.datasource.remote

import com.example.domain.entity.Category.CategoryResponse
import com.example.domain.entity.meals.Meal
import com.example.domain.entity.meals.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getCategory(): CategoryResponse

    @GET("filter.php")
    suspend fun getMealsWithCategory(@Query("c") strCategory: String ): MealsResponse
    @GET("lookup.php")
    suspend fun getDetailsMealById(@Query("i") idMeal: String): MealsResponse
}