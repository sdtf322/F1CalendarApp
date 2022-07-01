package com.example.f1calendarOP

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "F1 Calendar"
        setContentView(R.layout.activity_main)
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
