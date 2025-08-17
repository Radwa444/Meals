package com.example.data.repo.categories

import com.example.data.datasource.remote.ApiService
import com.example.domain.entity.Category.CategoryResponse
import com.example.domain.repo.categories.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(val apiService: ApiService): CategoryRepository {
    override suspend fun getCategory(): CategoryResponse {
        return apiService.getCategory()
    }
}