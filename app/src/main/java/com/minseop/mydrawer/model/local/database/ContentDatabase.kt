package com.minseop.mydrawer.model.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.minseop.mydrawer.model.local.dao.ContentDao
import com.minseop.mydrawer.model.local.entity.Content

@Database(entities = [Content::class], version = 1)
abstract class ContentDatabase: RoomDatabase() {

    abstract fun videoDao() : ContentDao

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