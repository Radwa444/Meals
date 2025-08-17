package com.example.mealzapp.ui.deailsmeal.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.meals.Meal
import com.example.domain.entity.meals.MealsResponse
import com.example.domain.usercase.detailmeal.DetailsMealUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailsMealViewModel @Inject constructor
    (private val detailsMealUserCase: DetailsMealUserCase): ViewModel() {
    private  val TAG = "detailsMealViewModel"
    private val _detailsMealStateFlow: MutableStateFlow<MealsResponse?> = MutableStateFlow(null)
    public  val   detailsMealStateFlow: StateFlow<MealsResponse?> =_detailsMealStateFlow
    @SuppressLint("SuspiciousIndentation")
    fun getDetailsMeal(idMeal: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
              _detailsMealStateFlow.value = detailsMealUserCase.getDetailsMealById(idMeal)
                Log.e(TAG, _detailsMealStateFlow.value?.meals?.get(0)?.strYoutube.toString())
            }catch (e: Exception){
               Log.e(TAG,e.toString())
            }

        }
    }



}