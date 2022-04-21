package com.example.f1calendarOP

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "F1 Calendar"
        setContentView(R.layout.activity_main)
        val raceListFragment = RaceListFragment()
        setCurrentFragment(raceListFragment)

        val standingsFragment = StandingsFragment()
        val driversFragment = DriversFragment()
        val constructorsFragment = ConstructorsFragment()

        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> setCurrentFragment(raceListFragment)
                R.id.miStandings -> setCurrentFragment(standingsFragment)
                R.id.miDrivers -> setCurrentFragment(driversFragment)
                R.id.miConsturtors -> setCurrentFragment(constructorsFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }
    //Toolbar menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAuthor -> Toast.makeText(this,"Author of this app is Olegs Pliska", Toast.LENGTH_LONG).show()
            R.id.miTheme -> Toast.makeText(this,"Switching to light/dark theme(IN PROGRESS)", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
