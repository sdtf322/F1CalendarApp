package com.example.f1calendarOP.utils

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.f1calendarOP.R

const val NOTIFICATION_ID = 1
const val CHANNEL_ID = "channel1"
const val NOTIF_TITLE = "F1 Calendar App"
const val NOTIF_MESSAGE = "This is a reminder of F1 GP"

class Notification : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val raceNotification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_driver)
            .setContentTitle(intent.getStringExtra(NOTIF_TITLE))
            .setContentText(intent.getStringExtra(NOTIF_MESSAGE))
            .build()

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, raceNotification)
    }
}