package com.hninor.pruebamercadolibre.ui

import MainCoroutineRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hninor.pruebamercadolibre.getOrAwaitValue
import com.hninor.pruebamercadolibre.repository.SearchRepository
import com.hninor.pruebamercadolibre.repository.entities.Response
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.pauseDispatcher
import kotlinx.coroutines.test.resumeDispatcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class SearchViewModelTest {


    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()


    @Test
    fun queryEmptyList_updateList() {
        mainCoroutineRule.pauseDispatcher()
        val repository = mockk<SearchRepository>()
        coEvery {
            repository.fetchResults("")
        } returns Response()
        val viewModel = SearchViewModel(repository)
        viewModel.search("")
        mainCoroutineRule.resumeDispatcher()
        assertThat(viewModel.result.getOrAwaitValue().isEmpty(), `is`(true))
    }



    @Test
    fun queryNotEmptyList_updateList() {
        mainCoroutineRule.pauseDispatcher()
        val viewModel = SearchViewModel(SearchRepository())
        viewModel.search("motorola")
        mainCoroutineRule.resumeDispatcher()
        assertThat(viewModel.result.getOrAwaitValue().isNotEmpty(), `is`(true))
    }

}