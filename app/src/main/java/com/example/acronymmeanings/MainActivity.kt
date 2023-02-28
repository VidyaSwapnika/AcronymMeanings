package com.example.acronymmeanings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acronymmeanings.adapter.MeaningsListAdapter
import com.example.acronymmeanings.databinding.ActivityMainBinding
import com.example.acronymmeanings.repository.MeaningsRepository
import com.example.acronymmeanings.service.RetrofitService
import com.example.acronymmeanings.viewmodel.MeaningViewModelFactory
import com.example.acronymmeanings.viewmodel.MeaningsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MeaningsViewModel

    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            MeaningViewModelFactory(MeaningsRepository(retrofitService))
        )[MeaningsViewModel::class.java]

        binding.btnSearch.setOnClickListener {
            viewModel.getMeaningsList(binding.etAcronym.text.toString() ?: "")
        }

        viewModel.meaningsList.observe(this, Observer {
            val adapter = MeaningsListAdapter(it[0].lfs)
            binding.rvMeaningsList.adapter = adapter
            binding.rvMeaningsList.layoutManager = LinearLayoutManager(this)
            binding.rvMeaningsList.addItemDecoration(
                DividerItemDecoration(
                    this,
                    LinearLayoutManager.VERTICAL
                )
            )
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        })
    }

}