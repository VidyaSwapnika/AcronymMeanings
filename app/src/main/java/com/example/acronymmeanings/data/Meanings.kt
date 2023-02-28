package com.example.acronymmeanings.data

data class Meanings(val sf : String, val lfs: List<LongForms>)

data class LongForms(val lf : String, val freq : Int, val since : Int)
