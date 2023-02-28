package com.example.acronymmeanings.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.acronymmeanings.data.LongForms
import com.example.acronymmeanings.databinding.AcronymListItemBinding

class AcronymViewHolder(
    private val binding: AcronymListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(description: LongForms) {
        binding.meaning = description
    }
}