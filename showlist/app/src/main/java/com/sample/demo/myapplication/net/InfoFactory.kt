package com.sample.demo.myapplication.net

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class InfoFactory(private var infoRepository: InfoRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoViewModel::class.java)) {
            return InfoViewModel(infoRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}

