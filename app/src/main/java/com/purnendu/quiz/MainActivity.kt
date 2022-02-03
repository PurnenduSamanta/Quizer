package com.purnendu.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO

class MainActivity : AppCompatActivity() {

    lateinit var play:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        play=findViewById(R.id.play)

        play.setOnClickListener {
            finish()
            startActivity(Intent(this,Questions::class.java))
        }
    }
}