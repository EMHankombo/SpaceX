package com.example.android.spacex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.android.spacex.R
import com.example.android.spacex.databinding.ActivitySpacexBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpaceXActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpacexBinding
    private val viewModel: SpaceXViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpacexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.companyLiveData.observe(this, {
            val info = (it as SpaceXViewModel.UiState.Success).data
            binding.tvCompanyInformation.text = getString(
                R.string.company_information,
                info.name,
                info.founded.toString(),
                info.employees.toString(),
                info.launchSites.toString(),
                info.valuation.toString()
            )

        })
    }
}