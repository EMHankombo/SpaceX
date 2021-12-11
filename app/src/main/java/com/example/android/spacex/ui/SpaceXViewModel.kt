package com.example.android.spacex.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpaceXViewModel @Inject constructor(private val spaceXRepository: SpaceXRepository) :
    ViewModel() {
}