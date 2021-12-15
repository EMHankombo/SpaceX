package com.example.android.spacex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.spacex.R
import com.example.android.spacex.databinding.ActivitySpacexBinding
import com.example.android.spacex.ui.adapter.SpaceXAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpaceXActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpacexBinding
    private val viewModel: SpaceXViewModel by viewModels()
    private val spaceXAdapter = SpaceXAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpacexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.companyLiveData.observe(this, {
            val info = (it as SpaceXViewModel.UiState.Success).data.company
            binding.tvCompanyInformation.text = getString(
                R.string.company_information,
                info.name,
                info.founder,
                info.founded.toString(),
                info.employees.toString(),
                info.launchSites.toString(),
                info.valuation.toString()
            )

            binding.rvLaunches.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = SpaceXAdapter(it.data.launches)
            }
        })

        viewModel.getCompanyData()
    }
}