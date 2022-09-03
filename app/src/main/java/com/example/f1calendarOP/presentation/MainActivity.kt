package com.example.f1calendarOP.presentation

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.f1calendarOP.R
import com.example.f1calendarOP.app.App
import com.example.f1calendarOP.databinding.ActivityMainBinding
import com.example.f1calendarOP.di.AppComponent
import com.example.f1calendarOP.utils.CHANNEL_ID
import com.example.f1calendarOP.utils.NOTIFICATION_ID
import com.example.f1calendarOP.utils.NOTIF_MESSAGE
import com.example.f1calendarOP.utils.NOTIF_TITLE
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var appComponent: AppComponent
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = (applicationContext as App).appComponent

        title = "F1 Calendar"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel()
    }

    private fun scheduleNotification() {
        val intent = Intent(applicationContext, Notification::class.java)
        val title = "Droopessa"
        val message = "Raketchica"
        intent.putExtra(NOTIF_TITLE, title)
        intent.putExtra(NOTIF_MESSAGE, message)

        val pendingIntent = PendingIntent.getService(
            applicationContext,
            NOTIFICATION_ID,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setAlarmClock(
            alarmManager.nextAlarmClock,
            pendingIntent
        )
        showAlert(time, title, message)
    }

    private fun showAlert(time: Long, title: String, message: String)
    {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)

        AlertDialog.Builder(this)
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title: " + title +
                        "\nMessage: " + message +
                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(date))
            .setPositiveButton("Okay"){_,_ ->}
            .show()
    }

    private fun getTime(): Long { // sets time for a notification
        val minute = 0
        val hour = 13
        val day = 3
        val month = 9
        val year = 2022

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // Android Oreo
            val name = "Notif Channel"
            val desc = "A Description of the Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = desc
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miAuthor -> Toast.makeText(
                this,
                "Author of this app is Olegs Pliska",
                Toast.LENGTH_LONG
            ).show()
            R.id.miTheme -> Toast.makeText(
                this,
                "Switching to light/dark theme(IN PROGRESS)",
                Toast.LENGTH_SHORT
            ).show()
        }
        return true
    }
}
