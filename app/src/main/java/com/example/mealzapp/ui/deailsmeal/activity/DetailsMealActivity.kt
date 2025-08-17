package com.example.mealzapp.ui.deailsmeal.activity

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.domain.entity.meals.Meal
import com.example.mealzapp.addNewLineEvery4Words
import com.example.mealzapp.databinding.ActivityDetailsMealBinding
import com.example.mealzapp.ui.deailsmeal.viewmodel.DetailsMealViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class DetailsMealActivity : AppCompatActivity() {
    private val TAG = "DetailsMealActivity"
        private lateinit var binding: ActivityDetailsMealBinding
         val viewModel: DetailsMealViewModel by viewModels()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            val dealsIntent=intent.getParcelableExtra<Meal?>("passing_id_meal")
            viewModel.getDetailsMeal(dealsIntent?.idMeal?:"")
            Log.d(TAG,dealsIntent?.idMeal.toString())
        }catch (e: Exception){
            Log.e(TAG,e.toString())
        }

        observesDetailMeal()



    }

    private fun observesDetailMeal() {
        lifecycleScope.launch {
            viewModel.detailsMealStateFlow.collect {
                value ->  setVideoView(value?.meals?.get(0)?.strYoutube.toString())
                binding.textTitleMealInActivityDetailsMeal.text=value?.meals?.get(0)?.strMeal

                binding.textInstructions.text= addNewLineEvery4Words( value?.meals?.get(0)?.strInstructions?:"",11)
                Log.d(TAG,value?.meals.toString())
            }
        }


    }

    private fun setVideoView(url:String) {
        try {
            val uri: Uri = Uri.parse(url)
            binding.videoView.setVideoURI(uri)
            val mediaController= MediaController(this)
            mediaController.setMediaPlayer(binding.videoView)
            binding.videoView.setMediaController(mediaController)
            binding.videoView.start()
            Log.d(TAG,TAG)
        }catch (e: Exception){
            Log.e(TAG,e.toString())
        }
    }


//    private fun setVideoUrl(url: String?) {
//        try {
//            val uri: Uri=Uri.parse(url)
//            binding.videoView.setVideoURI(uri)
//            val mediaController= MediaController(this)
//            mediaController.setMediaPlayer(binding.videoView)
//            binding.videoView.setMediaController(mediaController)
//            binding.videoView.start()
//            Log.e(TAG,TAG)
//        }catch (e: Exception){
//            Log.e(TAG,e.toString())
//        }

   // }
}