package com.example.f1calendarOP.presentation

import android.app.*
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.f1calendarOP.R
import com.example.f1calendarOP.app.App
import com.example.f1calendarOP.databinding.ActivityMainBinding
import com.example.f1calendarOP.di.AppComponent
import com.example.f1calendarOP.domain.usecases.NotifyUserAboutRaceUseCase
import com.example.f1calendarOP.utils.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var appComponent: AppComponent
    private lateinit var binding : ActivityMainBinding

    private val raceList by lazy { notifyUserAboutRaceUseCase.getList() }
    private val singaporeRace by lazy { raceList[16] }

    @Inject
    lateinit var notifyUserAboutRaceUseCase: NotifyUserAboutRaceUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = (applicationContext as App).appComponent

        appComponent.inject(this)

        title = "F1 Calendar"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("NOTIF_Main", "MainActivity call")

        createNotificationChannel()

        scheduleNotification()

    }

    private fun scheduleNotification()
    {
        val intent = Intent()
        val title = "F1 Calendar"
        val message = "Bahrain Grand Prix will start at 15:00"

        val action = "com.example.f1calendarOP.presentation.Notification"
        intent.putExtra(NOTIF_TITLE, title)
        intent.putExtra(NOTIF_MESSAGE, message)
        intent.action = action
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            NOTIFICATION_ID,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerReceiver(NotificationBroadcastReceiver(), IntentFilter(action))
        }

        val time = getTime()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                time,
                pendingIntent
            )
        }
        else {
            sendBroadcast(intent)
        }
        Log.i("NOTIF_Main", "Schedule Notification call()")
    }

    private fun getTime() : Long {

        val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val raceDate = singaporeRace.date // 2022-10-02
        val parsedDate = dateFormatter.parse(raceDate)

        val timeFormatter = SimpleDateFormat("HH:mm:ss'Z'")
        val raceTime = singaporeRace.time // 15:00:00Z
        val parsedTime = timeFormatter.parse(raceTime)

        parsedDate.hours = parsedTime.hours
        parsedDate.minutes = parsedTime.minutes
        parsedDate.seconds = parsedTime.seconds

        val calendar = Calendar.getInstance()

        with(parsedDate) {
            calendar.set(
                year + 1900,
                month + 1,
                date,
                hours,
                minutes,
                seconds
            )
        }

//        calendar.add(Calendar.YEAR, parsedDate.year + 1900)
//        calendar.add(Calendar.MONTH, parsedDate.month + 1)
//        calendar.add(Calendar.DAY_OF_MONTH, parsedDate.day)
//
//        calendar.add(Calendar.HOUR_OF_DAY, parsedTime.hours)
//        calendar.add(Calendar.MINUTE, parsedTime.minutes)
//        calendar.add(Calendar.SECOND, parsedTime.seconds)


        Log.i("ABOBA",
            (parsedDate.year + 1900).toString() + " " + (parsedDate.month + 1).toString() +
            " " + parsedDate.date.toString() + " " + parsedDate.hours.toString() + " " +
            parsedDate.minutes.toString() + " " + parsedDate.seconds.toString())
        Log.i("ABOBA",
            calendar.toString())

        return calendar.timeInMillis
    }

    private fun createNotificationChannel() { // Can be placed in different file

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notif Channel"
            val desc = "A Description of the Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = desc
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            Log.i("NOTIF_Main", "Create Notification Channel called")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miAuthor ->
                Toast.makeText(
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
