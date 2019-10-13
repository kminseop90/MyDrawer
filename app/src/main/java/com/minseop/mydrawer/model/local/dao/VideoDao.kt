package com.minseop.mydrawer.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.minseop.mydrawer.model.local.entity.Video

@Dao
interface VideoDao {
    @Query("SELECT * FROM video ORDER BY id ASC")
    fun getAll(): LiveData<List<Video>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(video: Video)

    @Delete
    fun delete(video: Video)
}