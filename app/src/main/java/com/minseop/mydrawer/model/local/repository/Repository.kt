package com.minseop.mydrawer.model.local.repository

import androidx.lifecycle.LiveData

interface Repository<T> {
    fun getAll() : LiveData<List<T>>

    fun insert(data: T)

    fun delete(data: T)
}