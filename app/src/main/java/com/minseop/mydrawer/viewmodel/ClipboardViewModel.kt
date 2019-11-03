package com.minseop.mydrawer.viewmodel

import androidx.lifecycle.LiveData
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.model.local.repository.ContentRepository
import com.minseop.mydrawer.ui.base.BaseViewModel

class ClipboardViewModel:  BaseViewModel() {
    private val repository = ContentRepository()
    private val videos = repository.getAll()

    fun getAll(): LiveData<List<Content>> = this.videos

    fun insert(content: Content) {
        repository.insert(content)
    }

    fun delete(content: Content) {
        repository.delete(content)
    }
}