package com.example.domain.usercase.category

import com.example.domain.entity.Category.CategoryResponse
import com.example.domain.repo.categories.CategoryRepository
import javax.inject.Inject

class CategoryUserCase @Inject constructor(private val categoryRepository: CategoryRepository){
    suspend operator fun invoke(): CategoryResponse {
       return categoryRepository.getCategory();
    }
}