package com.example.android.spacex.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.spacex.network.model.Company
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceXViewModel @Inject constructor(private val spaceXRepository: SpaceXRepository) :
    ViewModel() {

    private val _companyLiveData = MutableLiveData<UiState<Company>>()
    val companyLiveData: LiveData<UiState<Company>>
        get() = _companyLiveData

    fun getCompanyData() {
        viewModelScope.launch {
            try {
                val companyInfo = spaceXRepository.getCompanyInfo()
                _companyLiveData.value = UiState.Success(companyInfo)
            } catch (e: Exception) {

            }
        }
    }

    sealed class UiState<out T> {
        object Loading : UiState<Nothing>()
        object Error : UiState<Nothing>()
        data class Success<T>(val data: T) : UiState<T>()
    }
}