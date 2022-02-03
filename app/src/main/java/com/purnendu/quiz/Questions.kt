package com.purnendu.quiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class Questions : AppCompatActivity() {


    private lateinit var ans1: MaterialButton
    private lateinit var ans2: MaterialButton
    private lateinit var ans3: MaterialButton
    private lateinit var ans4: MaterialButton
    lateinit var timer: TextView
    private lateinit var listButton: ArrayList<MaterialButton>
    private lateinit var question: TextView
    private var count: Int = 0
    private var score: Int = 0
    private val list = QuestionModel.list
    private val ansList1 = QuestionModel.ans1ButtonList
    private val ansList2 = QuestionModel.ans2ButtonList
    private val ansList3 = QuestionModel.ans3ButtonList
    private val ansList4 = QuestionModel.ans4ButtonList
    lateinit var countDownTimer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


        ans1 = findViewById(R.id.ans1)
        ans2 = findViewById(R.id.ans2)
        ans3 = findViewById(R.id.ans3)
        ans4 = findViewById(R.id.ans4)
        question = findViewById(R.id.question)
        timer = findViewById(R.id.timer)

        listButton = arrayListOf(ans1, ans2, ans3, ans4)


        setTimer()
        setUpQuestionAndAnswer()



        ans1.setOnClickListener {

            if (isCompleted())
                checkAnswerLastQuestion(listButton[0])
            else {
                setButtonState(0, false)
                checkAnswer(listButton[0])
            }

        }


        ans2.setOnClickListener {

            if (isCompleted())
                checkAnswerLastQuestion(listButton[1])

            else {
                setButtonState(1, false)
                checkAnswer(listButton[1])
            }

        }


        ans3.setOnClickListener {

            if (isCompleted())
                checkAnswerLastQuestion(listButton[2])

            else {
                setButtonState(2, false)
                checkAnswer(listButton[2])
            }

        }


        ans4.setOnClickListener {

            if (isCompleted())
                checkAnswerLastQuestion(listButton[3])

            else {
                setButtonState(3, false)
                checkAnswer(listButton[3])
            }

        }

    }

    private fun setTimer() {

        countDownTimer = object : CountDownTimer(1000 * 16, 1000) {
            override fun onTick(p0: Long) {
                timer.text = (p0 / 1000).toString()
            }

            override fun onFinish() {
                if (isCompleted())
                    gameOver()
                else {
                    count++
                    setUpQuestionAndAnswer()
                    setButtonState(5, true)
                    countDownTimer.start()
                }
            }

        }.start()
    }


    private fun isCompleted(): Boolean = count == 4

    private fun gameOver() {
        val intent = Intent(this, GameOver::class.java)
        intent.putExtra("TOTAL", count + 1)
        intent.putExtra("SCORE", score)
        finish()
        startActivity(intent)
    }

    private fun setUpQuestionAndAnswer() {
        question.text = list[count].question
        ans1.text = ansList1[count]
        ans2.text = ansList2[count]
        ans3.text = ansList3[count]
        ans4.text = ansList4[count]
    }

    private fun checkAnswer(btn: MaterialButton) {
        countDownTimer.cancel()
        if (btn.text.equals(list[count].answer)) {
            btn.setBackgroundColor(Color.GREEN)
            score++
        } else
            btn.setBackgroundColor(Color.RED)
        count++
        Handler(Looper.getMainLooper()).postDelayed({
            btn.setBackgroundColor(Color.WHITE)
            setUpQuestionAndAnswer()
            setButtonState(5, true)
            countDownTimer.start()

        }, 1000)
    }


    private fun checkAnswerLastQuestion(btn: MaterialButton)
    {
        countDownTimer.cancel()
        if (btn.text.equals(list[count].answer)) {
            btn.setBackgroundColor(Color.GREEN)
            score++
        } else
            btn.setBackgroundColor(Color.RED)
        Handler(Looper.getMainLooper()).postDelayed({
            gameOver()
        }, 1000)
    }


    private fun setButtonState(btn: Int, isEnabled: Boolean) {
        for (i in 0..3) {
            if (i == btn)
                continue
            listButton[i].isEnabled = isEnabled
        }
    }
}