package com.example.domain.repo.categories

import com.example.domain.entity.Category.CategoryResponse

interface CategoryRepository {
  suspend  fun getCategory(): CategoryResponse
}