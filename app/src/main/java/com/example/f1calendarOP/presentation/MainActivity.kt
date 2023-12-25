package com.example.f1calendarOP.presentation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.f1calendarOP.R
import com.example.f1calendarOP.app.App
import com.example.f1calendarOP.di.AppComponent

class MainActivity : AppCompatActivity() {

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = (applicationContext as App).appComponent

        Log.d("ABOBA", appComponent.toString())

        title = getString(R.string.f1_calendar)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miAuthor -> Toast.makeText(
                this, getString(R.string.author_of_this_app_is_olegs_pliska), Toast.LENGTH_LONG
            ).show()
            R.id.miTheme -> Toast.makeText(
                this, getString(R.string.switching_to_light_dark_theme_in_progress), Toast.LENGTH_SHORT
            ).show()
        }
        return true
    }
}
