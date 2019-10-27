package com.minseop.mydrawer.service

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.minseop.mydrawer.ui.MainActivity
import com.minseop.mydrawer.util.ClipboardUtils
import com.orhanobut.logger.Logger


class ClipboardService : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


    override fun onCreate() {
        super.onCreate()
        startForegroundService()
        addClipBoardEvent()
    }

    private fun addClipBoardEvent() {
        ClipboardUtils.startClipBoardEventCatch {
            Logger.d(it?.text)
        }
    }

    private fun startForegroundService() {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= 26) {
            val CHANNEL_ID = "MyDrawer_service_channel"
            val channel = NotificationChannel(
                CHANNEL_ID,
                "MyDrawer Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                .createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, CHANNEL_ID)
        } else {
            builder = NotificationCompat.Builder(this)
        }
        builder.setSmallIcon(R.drawable.ic_delete)
            .setContentIntent(pendingIntent)

        startForeground(1, builder.build())
    }
}