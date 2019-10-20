package com.minseop.mydrawer.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _liveLoading = MutableLiveData<Boolean>().apply { value = false }
    val liveLoading: LiveData<Boolean> get() = _liveLoading

    fun showLoading() {
        _liveLoading.value = true
    }

    fun hideLoading() {
        _liveLoading.value = false
    }
}