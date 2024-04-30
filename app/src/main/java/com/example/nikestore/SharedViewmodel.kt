package com.example.nikestore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewmodel (): ViewModel() {

    var myShoe = mutableStateOf<Shoe?>(null)
    fun passShoe(newShoe: Shoe){
        myShoe.value = newShoe
    }
}