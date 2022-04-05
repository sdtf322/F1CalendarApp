package com.example.f1calendarOP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class RaceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_race_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Race week"
        //binding variables to textviews
        val trackDetailF1: TextView = findViewById(R.id.trackDetailF1) // Track name
        val trackDateF1: TextView = findViewById(R.id.dateF1_2) // Date of GP weekend
        val flagDetailF1: ImageView = findViewById(R.id.flagDetailF1) //Flag resource
        val session1Date : TextView = findViewById(R.id.session1Date)
        val session2Date : TextView = findViewById(R.id.session2Date)
        val session3Date : TextView = findViewById(R.id.session3Date)
        val session4Date : TextView = findViewById(R.id.session4Date)
        val session5Date : TextView = findViewById(R.id.session5Date)
        val session1Time : TextView = findViewById(R.id.session1Time)
        val session2Time : TextView = findViewById(R.id.session2Time)
        val session3Time : TextView = findViewById(R.id.session3Time)
        val session4Time : TextView = findViewById(R.id.session4Time)
        val session5Time : TextView = findViewById(R.id.session5Time)
        val session2 : TextView = findViewById(R.id.session2) // Practice 2 / Sprint Quali
        val session3 : TextView = findViewById(R.id.session3) // Practice 3 / Practice 2
        val session4 : TextView = findViewById(R.id.session4) // Quali / Sprint Race

        //Intent
        val dateString : String? = intent.getStringExtra("RACEDATE") // Date of F1(ex. 22-24 JUN)
        val trackString : String? = intent.getStringExtra("RACETRACK")
        val session1TimeString : String? = intent.getStringExtra("SESSION1TIME")
        val session2TimeString : String? = intent.getStringExtra("SESSION2TIME")
        val session3TimeString : String? = intent.getStringExtra("SESSION3TIME")
        val session4TimeString : String? = intent.getStringExtra("SESSION4TIME")
        val session5TimeString : String? = intent.getStringExtra("SESSION5TIME")
        flagDetailF1.setImageResource(intent.getStringExtra("RACEFLAG")!!.toInt())

        var testString : String?
        val testInt : Int

        // SPRINT RACES check, in this 3 races session names differs
        if(trackString == "Imola Grand Prix" || trackString == "Red Bull Ring Grand Prix" || trackString == "Brazil Grand Prix"){
            session2.text = getString(R.string.session_2_sprint)
            session3.text = getString(R.string.session_3_sprint)
            session4.text = getString(R.string.session_4_sprint)
        }

        //Binding information to existing textviews
        trackDateF1.text = dateString
        trackDetailF1.text = trackString
        session1Time.text = session1TimeString
        session2Time.text = session2TimeString
        session3Time.text = session3TimeString
        session4Time.text = session4TimeString
        session5Time.text = session5TimeString


        //------------------------------------------------------------------------------------------------------------
        /*Binding Session 1-5 date.
        Race weekend duration is 3 days(ex. 24-26 NOV) Session 1-2 is in 1st day, session 3-4
        is in 2nd day, session 5 is in 3rd day of weekend.*/



        //Setting Session 1,2 date
        // Extract first date and name of month from string
        testString = dateString?.take(2) + " " + dateString?.takeLast(3)
        val testString2 : String = dateString.toString()
        // Case when weekend happens in 2 different months(ex.SEP-OCT)
        if(testString2.length >= 10){
            testString = dateString?.take(2) + " " + dateString?.substring(6,9)
        }
        session1Date.text = testString
        session2Date.text = testString


        //Setting Session 5 date
        //Extract last date and name of month from string
        testString = dateString?.substring(3,5) + " " + dateString?.takeLast(3)
        session5Date.text = testString


        //Setting Session 3,4 date
        //If one date or another starts with 0
        if(testString.take(1) == "0" || testString.substring(3,4) == "0"){ // 30-02
            testInt = testString.substring(1,2).toInt() - 1
            testString = testString.take(1) + testInt.toString() + " " + dateString?.takeLast(3)
        }
        else{
            testString = (testString.substring(0,2).toInt() - 1).toString() + " " + dateString?.takeLast(3)
            //if result number in date is single digit
            if(testString.length == 5){
                testString = "0" + testString
            }
        }
        session3Date.text = testString
        session4Date.text = testString
    //------------------------------------------------------------------------------------------------------------
    }

    //Action bar overriding
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }
    //Adding icons to action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAuthor -> Toast.makeText(this,"Author of this app is Olegs Pliska", Toast.LENGTH_LONG).show()
            R.id.miTheme -> Toast.makeText(this,"Switching to light/dark theme(IN PROGRESS)", Toast.LENGTH_LONG).show()
        }
        return true
    }
}