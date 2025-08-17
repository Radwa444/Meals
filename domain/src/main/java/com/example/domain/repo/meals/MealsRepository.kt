package com.example.domain.repo.meals

import com.example.domain.entity.meals.MealsResponse

interface MealsRepository {
    suspend fun getMealsWithCategory(strCategory: String): MealsResponse
}