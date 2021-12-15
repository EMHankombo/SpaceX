package com.example.android.spacex.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.spacex.network.model.CompanyAndLaunchInfo
import com.example.android.spacex.ui.repository.SpaceXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceXViewModel @Inject constructor(private val spaceXRepository: SpaceXRepository) :
    ViewModel() {

    private val _data = MutableLiveData<UiState>()
    val data: LiveData<UiState>
        get() = _data

    fun getData() {
        _data.value = UiState.Loading
        viewModelScope.launch {
            try {
                val companyInfo = spaceXRepository.getData()
                _data.value = UiState.Success(companyInfo)
            } catch (e: Exception) {
                _data.value = UiState.Error
            }
        }
    }

    sealed class UiState {
        object Loading : UiState()
        object Error : UiState()
        data class Success(val data: CompanyAndLaunchInfo) : UiState()
    }
}