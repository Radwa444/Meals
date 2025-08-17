package com.example.mealzapp.ui.Category.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.Category.Category
import com.example.mealzapp.ui.Category.adapter.CategoriesAdapter
import com.example.mealzapp.ui.Category.viewmodel.MainViewModel
import com.example.mealzapp.databinding.ActivityMainBinding
import com.example.mealzapp.ui.meals.activity.MealsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
   private lateinit var categoriesAdapter: CategoriesAdapter

   private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        observer()
        viewModel.getAllCategories()
        setContentView(binding.root)

    }

    private fun setRecyclerView() {
        val linearLayoutManager= LinearLayoutManager(this)
        binding.categories.adapter=categoriesAdapter
        binding.categories.layoutManager=linearLayoutManager
        categoriesAdapter.setOnClickListener(object :
        CategoriesAdapter.OnClickListener{
            @SuppressLint("SuspiciousIndentation")
            override fun listener(
                position: Int,
                category: Category?
            ) {
              val intent=Intent(this@MainActivity, MealsActivity::class.java)
                intent.putExtra(NEXT_SCREEN,category )
                startActivity(intent)
            }

        })
    }

    private fun observer() {
        lifecycleScope.launch {
            viewModel.categories.collect {
             value ->categoriesAdapter= CategoriesAdapter(value)

                setRecyclerView()
            }
        }

    }
    companion object{
        const val NEXT_SCREEN="meals_screen"
    }
}