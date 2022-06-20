package com.mina.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

//    @Query("SELECT * FROM MovieItem  ORDER BY page ASC, id ASC")
//    fun getMovies(): PagingSource<Int, MovieItem>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(it: List<MovieItem>)
//
//    @Query("SELECT COUNT(*) FROM MovieItem")
//    suspend fun moviesCount(): Int
//
//    @Query("DELETE FROM MovieItem")
//    suspend fun deleteAll()
}