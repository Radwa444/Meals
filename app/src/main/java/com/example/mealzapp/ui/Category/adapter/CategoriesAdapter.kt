package com.example.mealzapp.ui.Category.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.entity.Category.Category
import com.example.domain.entity.Category.CategoryResponse
import com.example.mealzapp.addNewLineEvery4Words
import com.example.mealzapp.databinding.RecCategoriesBinding

class CategoriesAdapter(private val categories: CategoryResponse?): RecyclerView.Adapter<CategoriesAdapter.CategoriesAdapterViewHolder>() {
  private var onClickListener: OnClickListener?=null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapterViewHolder {
      val binding: RecCategoriesBinding = RecCategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoriesAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoriesAdapterViewHolder,
        position: Int
    ) {
      val category=categories?.categories[position]
        val strCategoryDescription:String=categories?.categories[position]?.strCategoryDescription?:""
        holder.binding.textTitle.text=category?.strCategory
        holder.binding.textDetails.text= addNewLineEvery4Words(strCategoryDescription)
        holder.binding.imageRec.load(category?.strCategoryThumb){
            crossfade(true)

        }
        holder.binding.imageRec.setOnClickListener {
           onClickListener?.listener(position,category)

        }

    }

    override fun getItemCount(): Int {
        return categories?.categories?.size?:0
    }
    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener=onClickListener
    }
 interface OnClickListener{
     fun listener(position: Int, category: Category?)
 }
    class CategoriesAdapterViewHolder(val binding: RecCategoriesBinding)
        : RecyclerView.ViewHolder(binding.root) {

    }

}




