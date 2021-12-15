package com.example.android.spacex.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.android.spacex.network.model.Company
import com.example.android.spacex.network.model.CompanyAndLaunchInfo
import com.example.android.spacex.network.model.Launch
import com.example.android.spacex.testrule.MainCoroutineRule
import com.example.android.spacex.ui.repository.SpaceXRepository
import com.example.android.spacex.ui.viewmodel.SpaceXViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SpaceXViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var repository: SpaceXRepository

    @Mock
    private lateinit var liveDataObserver: Observer<SpaceXViewModel.UiState>
    private lateinit var viewModel: SpaceXViewModel

    private val company = Company(1, 2021, "EL", 5, "Name", 85L, 30)
    private val launch = mutableListOf<Launch>()
    private lateinit var companyLaunchInfo: CompanyAndLaunchInfo


    @Before
    fun setUp() {
        viewModel = SpaceXViewModel(repository)
        viewModel.data.observeForever(liveDataObserver)
        companyLaunchInfo = CompanyAndLaunchInfo(company, launch)
    }

    @Test
    fun `call to get data returns successfully`() = coroutineRule.runBlockingTest {
        whenever(repository.getData()).thenReturn(companyLaunchInfo)

        viewModel.getData()

        verify(liveDataObserver).onChanged(SpaceXViewModel.UiState.Success(companyLaunchInfo))
    }

    @Test
    fun `call to get data returns with an error`() = coroutineRule.runBlockingTest {
        whenever(repository.getData()).thenAnswer { throw Exception("An error Occurred") }

        viewModel.getData()

        verify(liveDataObserver).onChanged(SpaceXViewModel.UiState.Error)
    }
}