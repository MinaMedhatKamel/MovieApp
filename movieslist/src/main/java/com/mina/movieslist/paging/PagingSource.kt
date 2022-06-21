package com.mina.movieslist.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.mina.movieslist.data.MovieUi
import com.mina.movieslist.domain.GetMoviesUseCase
import java.io.IOException


class MovieSource(val getMoviesUseCase: GetMoviesUseCase) : PagingSource<Int, MovieUi>() {
    override fun getRefreshKey(state: PagingState<Int, MovieUi>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieUi> {
        return try {
            val nextPage = params.key ?: 1
            val moviesList = getMoviesUseCase.invoke(page = nextPage)
            LoadResult.Page(
                data = moviesList.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (moviesList.data.isEmpty()) null else moviesList.page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}