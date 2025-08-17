package com.example.mealzapp.di

import com.example.data.datasource.remote.ApiService
import com.example.data.repo.categories.CategoryRepositoryImpl
import com.example.data.repo.detailsmeal.DetailsMealRepositoryImpl
import com.example.data.repo.meals.MealsRepositoryImpl
import com.example.domain.repo.categories.CategoryRepository
import com.example.domain.repo.detailsmeal.DetailsMealRepository
import com.example.domain.repo.meals.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providerCategoryRepository(apiService: ApiService): CategoryRepository=
        CategoryRepositoryImpl(apiService)

    @Provides
    fun providerMealsRepository(apiService: ApiService): MealsRepository=
        MealsRepositoryImpl(apiService)

    @Provides
    fun providerDetailsMeal(apiService: ApiService): DetailsMealRepository =
        DetailsMealRepositoryImpl(apiService)

}