package com.purnendu.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class GameOver : AppCompatActivity() {

    private lateinit var score:TextView
    private lateinit var playAgain:MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        score=findViewById(R.id.score)
        playAgain=findViewById(R.id.playAgain)

        val intent=intent
        val total=intent.getIntExtra("TOTAL",0).toString()
        val scoreResult=intent.getIntExtra("SCORE",0).toString()

        score.text="$scoreResult/$total"


        playAgain.setOnClickListener {
            finish()
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAndRemoveTask()
    }
}