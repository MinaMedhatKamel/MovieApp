package com.mina.movieslist.domain

import com.mina.movieslist.FakeDataProvider
import com.mina.movieslist.data.IMovieRepo
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetMoviesUseCaseTest {
    @MockK
    private lateinit var repo: IMovieRepo

    private lateinit var retrieveAdsUseCase: GetMoviesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        retrieveAdsUseCase = GetMoviesUseCase(repo)
    }

    @Test
    fun `test when involk getNotes should call getNotes from the repo`() {
        val fakeMoviesResponse = FakeDataProvider.provideFakeSuccessMoviesRepoResponse()
        val fakeMoviesUiList = FakeDataProvider.provideFakeMoviesUiList()
        //setUp
        coEvery {
            repo.getTrendingMovies(1)
        } returns fakeMoviesResponse

        //when
        //run suspended test function
        runTest {
            val result = retrieveAdsUseCase.invoke(1)
            //then
            coVerify(exactly = 1) { repo.getTrendingMovies(1) }
            //assertion
            assertEquals(fakeMoviesUiList, result)
        }
    }
}