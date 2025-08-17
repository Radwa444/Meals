package com.example.domain.usercase.detailmeal

import com.example.domain.entity.meals.Meal
import com.example.domain.entity.meals.MealsResponse
import com.example.domain.repo.detailsmeal.DetailsMealRepository
import javax.inject.Inject

class DetailsMealUserCase @Inject constructor(private val detailsMealRepository: DetailsMealRepository){
    suspend  fun getDetailsMealById (idMeal: String): MealsResponse {
        return detailsMealRepository.getDetailsMealById(idMeal)
    }
}