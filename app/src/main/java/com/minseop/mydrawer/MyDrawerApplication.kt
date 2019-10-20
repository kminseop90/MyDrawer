package com.minseop.mydrawer

import android.app.Application
import android.content.Context
import com.minseop.mydrawer.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyDrawerApplication: Application() {


    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyDrawerApplication)
            modules(viewModelModule)
        }
        context = applicationContext
    }
}