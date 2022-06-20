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
    private val dispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getMoviesUseCase: GetMoviesUseCase

    lateinit var vm: MovieListViewModel

    val intFlow = MutableStateFlow(0)

    suspend fun emit(value: Int) {
        intFlow.emit(value)
    }

    @Test fun testFlow(){

        runBlockingTest {
            emit(5)
            delay(1000)
            emit(4)
            emit(3)
            intFlow.test {
                val item1 = awaitItem()
                assertEquals(5,item1)
                val item2 = awaitItem()
                assertEquals(4,item2)
            }
        }
    }

    val fakeMovies = listOf(
        MovieUi(
            id = 1, title = "title", imgUrl = "test img", "123"
        ), MovieUi(
            id = 2, title = "title2", imgUrl = "test img2", "1234"
        )
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(dispatcher)

        //setUp
        coEvery {
            getMoviesUseCase.invoke()
        } returns fakeMovies

        vm = MovieListViewModel(getMoviesUseCase)
    }


    @Test
    fun `check the initial state`() {
        dispatcher.runBlockingTest {
            vm.state.test {

                val LoadingState = awaitItem()
                assertEquals(
                    MoviesState(isLoading = false, movies = fakeMovies),
                    LoadingState
                )
//                val dataState = awaitItem()
//                assertEquals(
//                    dataState,
//                    MoviesState(isLoading = false , movies = fakeMovies)
//                )fakeMovies
            }
        }
    }
}