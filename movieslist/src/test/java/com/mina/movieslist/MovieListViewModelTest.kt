package com.mina.movieslist

import app.cash.turbine.test
import com.mina.movieslist.data.MovieUi
import com.mina.movieslist.domain.GetMoviesUseCase
import com.mina.movieslist.intent.MoviesIntent
import com.mina.movieslist.state.MoviesState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class MovieListViewModelTest {

    @MockK
    lateinit var getMoviesUseCase: GetMoviesUseCase

    private lateinit var vm: MovieListViewModel


    @Before
    fun setup() {
        MockKAnnotations.init(this)
        vm = MovieListViewModel(getMoviesUseCase)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `check the feach movies state when loading the fragment`() {
        val fakeMovies = FakeDataProvider.provideFakeMoviesUiList()
        //setup
        coEvery {
            getMoviesUseCase.invoke()
        } returns fakeMovies
        //for running asynchronous operations in the test scope
        runTest {
            vm.state.test {
                val dataState = awaitItem()
                //assertion
                assertEquals(
                    dataState,
                    MoviesState(isLoading = false, movies = fakeMovies)
                )
            }
        }
    }
}