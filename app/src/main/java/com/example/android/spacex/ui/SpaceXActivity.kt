package com.example.android.spacex.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.spacex.R
import com.example.android.spacex.databinding.ActivitySpacexBinding
import com.example.android.spacex.network.model.CompanyAndLaunchInfo
import com.example.android.spacex.ui.adapter.SpaceXAdapter
import com.example.android.spacex.ui.viewmodel.SpaceXViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpaceXActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpacexBinding
    private val viewModel: SpaceXViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpacexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.data.observe(this, {
            when (it) {
                is SpaceXViewModel.UiState.Loading -> showProgress()
                is SpaceXViewModel.UiState.Error -> showErrorMessage()
                is SpaceXViewModel.UiState.Success -> displayUi(it.data)
            }
        })

        viewModel.getData()

        binding.errorState.btnTryAgain.setOnClickListener {
            viewModel.getData()
        }
    }

    private fun displayUi(data: CompanyAndLaunchInfo) {
        val company = data.company
        with(binding) {
            progress.progressContainer.visibility = View.GONE
            group.visibility = View.VISIBLE

        }
        binding.tvCompanyInformation.text = getString(
            R.string.company_information,
            company.name,
            company.founder,
            company.founded.toString(),
            company.employees.toString(),
            company.launch_sites.toString(),
            company.valuation.toString()
        )

        binding.rvLaunches.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SpaceXAdapter(data.launches) {

                val items = arrayOf(
                    getString(R.string.dialog_article),
                    getString(R.string.dialog_wikipedia),
                    getString(R.string.dialog_youtube)
                )

                MaterialAlertDialogBuilder(context)
                    .setTitle(getString(R.string.dialog_message))
                    .setItems(items) { _, which ->
                        // Respond to item chosen
                        when (which) {
                            0 -> launchArticle(it.article)
                            1 -> launchArticle(it.wikipedia)
                            2 -> launchArticle(it.webcast)
                        }
                    }
                    .show()
            }
        }
    }

    private fun showErrorMessage() {
        with(binding) {
            progress.progressContainer.visibility = View.GONE
            errorState.errorContainer.visibility = View.VISIBLE
            group.visibility = View.GONE

        }
    }

    private fun showProgress() {
        with(binding) {
            progress.progressContainer.visibility = View.VISIBLE
            errorState.errorContainer.visibility = View.GONE
            group.visibility = View.GONE
        }
    }

    private fun launchArticle(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}