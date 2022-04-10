package com.example.f1calendarOP

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RacesAdapter.MyOnClickListener{
    private val raceList = ArrayList<RaceF1>()
    private val racesAdapter: RacesAdapter by lazy { RacesAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "F1 Calendar"
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(applicationContext)

        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = racesAdapter
        prepareRaceData()
    }
    //F1 2022 Calendar Info
    private fun prepareRaceData() {
        var race = RaceF1("18-20 MAR", "Bahrain Grand Prix", R.drawable.flag_bahrain,
        "15:00", "18:00", "15:00", "18:00","18:00")
        raceList.add(race)
        race = RaceF1("25-27 MAR", "Jeddah Grand Prix", R.drawable.flag_saudi,
        "17:00", "20:00", "17:00", "20:00", "20:00")
        raceList.add(race)
        race = RaceF1("08-10 APR", "Melbourne Grand Prix", R.drawable.flag_australia,
        "06:00","09:00","06:00","09:00","08:00")
        raceList.add(race)
        race = RaceF1("22-24 APR", "Imola Grand Prix", R.drawable.flag_italy,
        "14:30", "18:00","13:30","17:30","16:00")
        raceList.add(race)
        race = RaceF1("06-08 MAY", "Miami Grand Prix", R.drawable.flag_us,
        "21:30","00:30","20:00","23:00","22:30")
        raceList.add(race)
        race = RaceF1("20-22 MAY", "Catalunya Grand Prix", R.drawable.flag_spain,
        "15:00","18:00","14:00","17:00","16:00")
        raceList.add(race)
        race = RaceF1("27-29 MAY", "Monaco Grand Prix", R.drawable.flag_monaco,
        "15:00","18:00","14:00","17:00","16:00")
        raceList.add(race)
        race = RaceF1("10-12 JUN", "Azerbaijan Grand Prix", R.drawable.flag_azerbaijan,
        "14:00","17:00","14:00","17:00","14:00")
        raceList.add(race)
        race = RaceF1("17-19 JUN", "Canadian Grand Prix", R.drawable.flag_canada,
        "21:00", "00:00","20:00","23:00", "21:00")
        raceList.add(race)
        race = RaceF1("01-03 JUL", "Silverstone Grand Prix", R.drawable.flag_uk,
        "15:00","18:00", "14:00", "17:00", "17:00")
        raceList.add(race)
        race = RaceF1("08-10 JUL", "Red Bull Ring Grand Prix", R.drawable.flag_austria,
        "14:30","18:00","13:30", "17:30","16:00")
        raceList.add(race)
        race = RaceF1("22-24 JUL", "French Grand Prix", R.drawable.flag_france,
        "15:00", "18:00","14:00", "17:00", "16:00")
        raceList.add(race)
        race = RaceF1("29-31 JUL", "Hungarian Grand Prix", R.drawable.flag_hungary,
        "15:00", "18:00", "14:00", "17:00", "16:00")
        raceList.add(race)
        race = RaceF1("26-28 AUG", "Spa-francorchamps Grand Prix", R.drawable.flag_belgium,
        "15:00", "18:00","14:00", "17:00", "16:00")
        raceList.add(race)
        race = RaceF1("02-04 SEP", "Zandvoort Grand Prix", R.drawable.flag_netherlands,
        "15:00", "18:00", "14:00", "17:00", "16:00")
        raceList.add(race)
        race = RaceF1("09-11 SEP", "Monza Grand Prix", R.drawable.flag_italy,
        "15:00", "18:00","14:00", "17:00", "16:00")
        raceList.add(race)
        race = RaceF1("30-02 SEP-OCT", "Singapore Grand Prix", R.drawable.flag_singapore,
        "13:00", "16:00", "13:00", "16:00", "15:00")
        raceList.add(race)
        race = RaceF1("07-09 OCT", "Suzuka Circuit Grand Prix", R.drawable.flag_japan,
        "07:00", "10:00", "07:00", "10:00", "08:00")
        raceList.add(race)
        race = RaceF1("21-23 OCT", "United States Grand Prix", R.drawable.flag_us,
        "22:00", "01:00", "22:00", "01:00", "22:00")
        raceList.add(race)
        race = RaceF1("28-30 OCT", "Mexico Grand Prix", R.drawable.flag_mexico,
        "21:00", "00:00", "20:00", "23:00", "22:00")
        raceList.add(race)
        race = RaceF1("11-13 NOV", "Brazil Grand Prix",  R.drawable.flag_brazil,
        "17:30", "21:00", "17:30", "21:30", "20:00")
        raceList.add(race)
        race = RaceF1("18-20 NOV", "Abu Dhabi Grand Prix", R.drawable.flag_uae,
        "12:00", "15:00", "13:00", "16:00", "15:00")
        raceList.add(race)
        racesAdapter.updateList(raceList)
    }
    //Onn click function transferring to new activity with sent data
    override fun OnClick(race: RaceF1, position: Int) {
        val intent = Intent(this, RaceDetailActivity::class.java)
        intent.putExtra(RACE_DATE_KEY, race)
        startActivity(intent)
    }

    companion object{
        const val RACE_DATE_KEY = "RACETRACK"
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