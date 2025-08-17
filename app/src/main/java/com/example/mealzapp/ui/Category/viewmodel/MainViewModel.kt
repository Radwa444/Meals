package com.example.mealzapp.ui.Category.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Category.CategoryResponse
import com.example.domain.usercase.category.CategoryUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(private val categoryUserCase: CategoryUserCase): ViewModel() {
private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    public val categories: StateFlow<CategoryResponse?> = _categories
    val strCategory: MutableStateFlow<String> = MutableStateFlow("")
    private val TAG = "MainViewModel"

    fun getAllCategories(){
       viewModelScope.launch(Dispatchers.IO) {
           try {
               _categories.value= categoryUserCase()

           }catch (e: Exception){
               Log.e(TAG,e.toString())
           }

        }
    }
    fun getStrCategory(strCategory: String){
        this.strCategory.value=strCategory

    }


}