package com.example.data.repo.detailsmeal

import com.example.data.datasource.remote.ApiService
import com.example.domain.entity.meals.Meal
import com.example.domain.entity.meals.MealsResponse
import com.example.domain.repo.detailsmeal.DetailsMealRepository
import javax.inject.Inject

class DetailsMealRepositoryImpl @Inject constructor(private val apiService: ApiService): DetailsMealRepository {
    override suspend fun getDetailsMealById(idMeal: String): MealsResponse {
        return apiService.getDetailsMealById(idMeal)
    }
}