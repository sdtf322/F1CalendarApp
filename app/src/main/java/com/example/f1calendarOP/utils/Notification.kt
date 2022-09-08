package com.example.f1calendarOP.utils

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.f1calendarOP.R

const val NOTIFICATION_ID = 1
const val CHANNEL_ID = "channel1"
const val NOTIF_TITLE = "titleExtra"
const val NOTIF_MESSAGE = "messageExtra"

class Notification : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val raceNotification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(intent.getStringExtra(NOTIF_TITLE))
            .setContentText(intent.getStringExtra(NOTIF_MESSAGE))
            .build()

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, raceNotification)
    }
}