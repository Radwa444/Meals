package com.example.mealzapp.di

import com.example.domain.repo.categories.CategoryRepository
import com.example.domain.repo.detailsmeal.DetailsMealRepository
import com.example.domain.repo.meals.MealsRepository
import com.example.domain.usercase.category.CategoryUserCase
import com.example.domain.usercase.detailmeal.DetailsMealUserCase
import com.example.domain.usercase.meals.MealsUserCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserCaseModule {
    @Provides
    fun providerCategoryUserCase(categoryRepository: CategoryRepository): CategoryUserCase=
        CategoryUserCase(categoryRepository)
    @Provides
    fun providerMealsUserCase(mealsRepository: MealsRepository): MealsUserCase=
        MealsUserCase(mealsRepository)

    @Provides
    fun providerDetailsMealsUserCase(detailsMealRepository: DetailsMealRepository): DetailsMealUserCase=
        DetailsMealUserCase(detailsMealRepository)
}