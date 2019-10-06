package com.minseop.mydrawer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.minseop.mydrawer.model.local.entity.Video
import com.minseop.mydrawer.model.local.repository.ContentRepository

class DashBoardViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ContentRepository(application)
    private val videos = repository.getAll()

    fun getAll(): LiveData<List<Video>> = this.videos

    fun insert(video: Video) {
        repository.insert(video)
    }

    fun delete(video: Video) {
        repository.delete(video)
    }


}