package com.example.mealzapp.ui.meals.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.entity.Category.Category
import com.example.domain.entity.meals.Meal
import com.example.mealzapp.databinding.ActivityMealsBinding
import com.example.mealzapp.ui.deailsmeal.activity.DetailsMealActivity
import com.example.mealzapp.ui.meals.adapter.MealsAdapter
import com.example.mealzapp.ui.meals.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMealsBinding
    private lateinit var adapter: MealsAdapter
    private val viewModel: MealsViewModel by viewModels()

    private  val TAG = "MealsActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observesMealsStateFlow()
        getIntentResponse()









    }

    private fun observesMealsStateFlow() {
        lifecycleScope.launch {
            viewModel.mealsStateFlow.collect {
                value -> adapter= MealsAdapter(value)
                setRecycleView()

            }
        }

    }

    private fun setRecycleView() {
        val layoutInflater= GridLayoutManager(this,2)
        binding.meals.layoutManager=layoutInflater
        binding.meals.adapter=adapter
        adapter.setOnClickListener(object : MealsAdapter.OnClickListener{
            override fun listener(
                position: Int,
                model: Meal?
            ) {
                try {
                    val mealIntent= Intent(this@MealsActivity, DetailsMealActivity::class.java)
                    mealIntent.putExtra("passing_id_meal",model)
                    startActivity(mealIntent)
                    Log.d(TAG,model?.idMeal.toString())
                }catch (e: Exception){
                    Log.e(TAG,e.toString())
                }

            }

        })

    }

    private fun getIntentResponse() {

        try {
            val intentResponse=intent.getParcelableExtra<Category?>("meals_screen")
            viewModel.getMealsWithCategory(intentResponse?.strCategory?:"")
            Log.d(TAG,intentResponse.toString())
        }catch (e: Exception){
            Log.e(TAG,e.toString())
        }

    }
}