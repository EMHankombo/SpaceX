package com.example.android.spacex.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.spacex.network.model.Company
import com.example.android.spacex.network.model.CompanyAndLaunchInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceXViewModel @Inject constructor(private val spaceXRepository: SpaceXRepository) :
    ViewModel() {

    private val _companyLiveData = MutableLiveData<UiState>()
    val companyLiveData: LiveData<UiState>
        get() = _companyLiveData

    fun getCompanyData() {
        viewModelScope.launch {
            try {
                val companyInfo = spaceXRepository.getData()
                _companyLiveData.value = UiState.Success(companyInfo)
            } catch (e: Exception) {
                _companyLiveData.value = UiState.Error
            }
        }
    }

    sealed class UiState {
        object Loading : UiState()
        object Error : UiState()
        data class Success(val data: CompanyAndLaunchInfo) : UiState()
    }
}