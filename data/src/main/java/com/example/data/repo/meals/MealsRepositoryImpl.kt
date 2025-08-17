package com.example.data.repo.meals

import com.example.data.datasource.remote.ApiService
import com.example.domain.entity.meals.MealsResponse
import com.example.domain.repo.meals.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(private val apiService: ApiService) : MealsRepository {
    override suspend fun getMealsWithCategory(strCategory: String): MealsResponse {
        return apiService.getMealsWithCategory(strCategory)
    }
}