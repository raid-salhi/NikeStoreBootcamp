package com.example.nikestore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewmodel (): ViewModel() {

    var myShoe = mutableStateOf(
        Shoe(name="Nike Essential", category = "Running", price = 182.34, pic = R.drawable.nike_shoe_3)
    )
    fun passShoe(newShoe: Shoe){
        myShoe.value = newShoe
    }
}