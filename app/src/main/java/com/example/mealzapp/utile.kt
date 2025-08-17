package com.example.mealzapp

 fun addNewLineEvery4Words(strCategoryDescription: String,num: Int=4): String {
    val description = strCategoryDescription.split(" ")
    return description.chunked(num).joinToString("\n") {
        it.joinToString(" ")
    }
}