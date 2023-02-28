package com.example.acronymmeanings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acronymmeanings.data.LongForms
import com.example.acronymmeanings.databinding.AcronymListItemBinding

class MeaningsListAdapter(
    private val meaningsList: List<LongForms>
) : RecyclerView.Adapter<AcronymViewHolder>() {
    private lateinit var binding: AcronymListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymViewHolder {
        binding = AcronymListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AcronymViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) {
        val meaning = meaningsList[position]
        holder.bind(meaning)
    }

    override fun getItemCount(): Int = meaningsList.size


}


