package com.example.acronymmeanings.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acronymmeanings.data.Meanings
import com.example.acronymmeanings.repository.MeaningsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeaningsViewModel constructor(private val repository: MeaningsRepository) : ViewModel() {

    val meaningsList = MutableLiveData<List<Meanings>>()
    val errorMessage = MutableLiveData<String>()

    fun getMeaningsList(definition: String) {
        val response = repository.getMeanings(definition)
        Log.e("Acronym", "text text 20 20 20 20")

        response.enqueue(object : Callback<List<Meanings>>{
            override fun onResponse(
                call: Call<List<Meanings>>,
                response: Response<List<Meanings>>
            ) {
                Log.e("Acronym", "text text 27 27 27 27")

                Log.e("View Model", "text text ${response.body()}")
                meaningsList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Meanings>>, t: Throwable) {
                errorMessage.postValue(t.message)

            }

        })
    }
}