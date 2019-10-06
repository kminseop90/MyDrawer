package com.minseop.mydrawer.model.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.minseop.mydrawer.model.local.dao.VideoDao
import com.minseop.mydrawer.model.local.entity.Video

@Database(entities = [Video::class], version = 1)
abstract class ContentDatabase: RoomDatabase() {

    abstract fun videoDao() : VideoDao

    companion object {
        private var INSTANCE: ContentDatabase? = null

        fun getInstance(context: Context): ContentDatabase? {
            if (INSTANCE == null) {
                synchronized(ContentDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContentDatabase::class.java, "content")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}