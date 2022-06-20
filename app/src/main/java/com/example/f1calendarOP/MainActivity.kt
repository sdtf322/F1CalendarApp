package com.example.f1calendarOP

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Communicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "F1 Calendar"
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = (supportFragmentManager.findFragmentById(R.id.flFragment) as NavHostFragment)
            .navController
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun openFragment(SomeFragment: Fragment) {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.apply{
            add(R.id.flFragment, SomeFragment)
            addToBackStack(null)
            commit()
        }
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
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}
