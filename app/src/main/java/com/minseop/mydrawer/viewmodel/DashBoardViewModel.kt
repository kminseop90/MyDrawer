package com.minseop.mydrawer.viewmodel

import androidx.lifecycle.LiveData
import com.minseop.mydrawer.model.local.entity.Video
import com.minseop.mydrawer.model.local.repository.ContentRepository
import com.minseop.mydrawer.ui.base.BaseViewModel

class DashBoardViewModel:  BaseViewModel() {
    private val repository = ContentRepository()
    private val videos = repository.getAll()

    fun getAll(): LiveData<List<Video>> = this.videos

    fun insert(video: Video) {
        repository.insert(video)
    }

    fun delete(video: Video) {
        repository.delete(video)
    }


}