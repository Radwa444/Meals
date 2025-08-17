package com.example.domain.repo.detailsmeal

import com.example.domain.entity.meals.Meal
import com.example.domain.entity.meals.MealsResponse

interface DetailsMealRepository {
    suspend fun getDetailsMealById (idMeal: String): MealsResponse
}