package com.example.acronymmeanings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.acronymmeanings.repository.MeaningsRepository

class MeaningViewModelFactory constructor(
    private val repository: MeaningsRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MeaningsViewModel::class.java)) {
            MeaningsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}