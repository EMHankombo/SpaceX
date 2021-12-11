package com.example.android.spacex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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

    }
}