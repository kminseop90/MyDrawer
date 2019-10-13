package com.minseop.mydrawer.model.local.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.minseop.mydrawer.model.local.dao.VideoDao
import com.minseop.mydrawer.model.local.database.ContentDatabase
import com.minseop.mydrawer.model.local.entity.Video

class ContentRepository(application: Application) : Repository<Video> {
    private val contentDatabase = ContentDatabase.getInstance(application)!!

    private val videoDao: VideoDao = contentDatabase.videoDao()

    private val videos: LiveData<List<Video>> = videoDao.getAll()


    override fun getAll(): LiveData<List<Video>> = videos

    override fun insert(video: Video) {
        try {
            val thread = Thread {
                videoDao.insert(video)
            }
            thread.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun delete(video: Video) {
        try {
            val thread = Thread{
                videoDao.delete(video)
            }
            thread.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}