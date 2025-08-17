package com.example.domain.usercase.meals

import com.example.domain.entity.meals.MealsResponse
import com.example.domain.repo.meals.MealsRepository
import javax.inject.Inject

class MealsUserCase @Inject constructor(private val mealsRepository: MealsRepository) {
    suspend fun getMealsWithCategory(strCategory:String): MealsResponse{
        return mealsRepository.getMealsWithCategory(strCategory)
    }
}
