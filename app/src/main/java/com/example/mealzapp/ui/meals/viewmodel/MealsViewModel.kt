package com.example.mealzapp.ui.meals.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.usercase.meals.MealsUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.meals.MealsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val mealsUserCase: MealsUserCase): ViewModel() {
    private  val TAG = "MealsViewModel"
    private val _mealsStateFlow: MutableStateFlow<MealsResponse?> = MutableStateFlow(null)
     val mealsStateFlow: StateFlow<MealsResponse?> =_mealsStateFlow
    fun getMealsWithCategory(strCategory: String){
        viewModelScope.launch {
            try {
                _mealsStateFlow.value=mealsUserCase.getMealsWithCategory(strCategory)
                Log.d(TAG,_mealsStateFlow.value.toString())
            }catch (e: Exception){
                Log.e(TAG,e.toString())
            }

        }

    }

}