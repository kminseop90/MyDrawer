package com.minseop.mydrawer.model.local.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.minseop.mydrawer.MyDrawerApplication
import com.minseop.mydrawer.model.local.dao.ContentDao
import com.minseop.mydrawer.model.local.database.ContentDatabase
import com.minseop.mydrawer.model.local.entity.Content

class ContentRepository : Repository<Content> {
    private val contentDatabase = ContentDatabase.getInstance(MyDrawerApplication.context)!!

    private val contentDao: ContentDao = contentDatabase.videoDao()

    private val contents: LiveData<List<Content>>? = contentDao.getAll()


    override fun getAll(): LiveData<List<Content>> = contents ?: MutableLiveData()

    override fun insert(content: Content) {
        try {
            val thread = Thread {
                contentDao.insert(content)
            }
            thread.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun delete(content: Content) {
        try {
            val thread = Thread{
                contentDao.delete(content)
            }
            thread.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}