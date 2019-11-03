package com.minseop.mydrawer.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.minseop.mydrawer.model.local.entity.Content

@Dao
interface ContentDao {
    @Query("SELECT * FROM content ORDER BY id ASC")
    fun getAll(): LiveData<List<Content>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(content: Content)

    @Delete
    fun delete(content: Content)
}