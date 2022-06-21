package com.mina.moviedetails

import app.cash.turbine.test
import com.mina.moviedetails.domain.GetMoviesDetailsUseCase
import com.mina.moviedetails.intent.MoviesDetailsIntent
import com.mina.moviedetails.state.MovieDetailsState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@ExperimentalCoroutinesApi
class MovieDetailsViewModelTest {
    val dispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getMoviesDetailsUseCase: GetMoviesDetailsUseCase

    private lateinit var vm: MovieDetailsViewModel

    val fakeMovieUi = FakeDataDetailsProvider.provideFakeMoviesDetailsUi()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
        //setup
        coEvery {
            getMoviesDetailsUseCase.invoke(1)
        } returns fakeMovieUi
        vm = MovieDetailsViewModel(getMoviesDetailsUseCase)
    }


    @OptIn(ExperimentalCoroutinesApi::class, ExperimentalTime::class)
    @Test
    fun `check the fetch movies details state when send an intent of FetchMoviesDetails`() {
        runTest {
            vm.sendAction(MoviesDetailsIntent.FetchMoviesDetails(1))
            vm.state.test {
                val dataState = awaitItem()
                //assertion
                assertEquals(
                    dataState,
                    MovieDetailsState(isLoading = false, movieDetail = fakeMovieUi)
                )
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}