package com.example.mealzapp.ui.meals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.entity.meals.Meal
import com.example.domain.entity.meals.MealsResponse
import com.example.mealzapp.databinding.RecMealsBinding

class MealsAdapter(private val mealsResponse: MealsResponse?): RecyclerView.Adapter<MealsAdapter.MealsAdapterViewHolder>() {
    private lateinit var onClickListener: OnClickListener
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealsAdapterViewHolder {
        val binding= RecMealsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MealsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MealsAdapterViewHolder,
        position: Int
    ) {
        val meal=mealsResponse?.meals[position]
        holder.binding.textTitleMeal.text=meal?.strMeal
        holder.binding.imageMeal.load(meal?.strMealThumb){
            crossfade(true)
        }
        holder.binding.imageMeal.setOnClickListener {
            onClickListener.listener(position,meal)
        }

    }

    override fun getItemCount(): Int {
       return mealsResponse?.meals?.size?:0
    }
    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener=onClickListener
    }
    interface OnClickListener{
        fun listener(position: Int,model: Meal?)
    }
    class MealsAdapterViewHolder(val binding: RecMealsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}