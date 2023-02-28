package com.example.acronymmeanings.repository

import com.example.acronymmeanings.service.RetrofitService

class MeaningsRepository constructor(private val retrofitService: RetrofitService){

    fun getMeanings(definition: String) = retrofitService.getAllMeanings(definition)
}