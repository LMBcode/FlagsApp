package com.example.flagsapp.UI

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.InputFilter
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.flagsapp.Model.Flags
import com.example.flagsapp.Model.QuestionsSource
import com.example.flagsapp.R
import com.example.flagsapp.databinding.ActivityGuessTheFlagBinding

class GuessTheFlagActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentQuestion : Int = 1
    private var mQuestionsList : List<Flags>? = null
    private lateinit var timer : CountDownTimer
    private var mCorrectAnswers : Int = 0
    private var isRunning = true
    private var mUsername : String? = null
    private lateinit var _binding : ActivityGuessTheFlagBinding
    private val binding get() =  _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGuessTheFlagBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mQuestionsList = QuestionsSource.guessFlags()
        Log.d("TAG",mQuestionsList?.size.toString())
        setQuestion()
        binding.guess.filters += InputFilter.AllCaps()
        mUsername = intent.getStringExtra(QuestionsSource.Username)
        binding.sumbit.setOnClickListener(this)

    }
    private fun setCountDownTimer(){
        timer = object : CountDownTimer(16000,1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(p0: Long) {
                isRunning = true
                Log.d("TAG10",isRunning.toString())
                binding.timer.text = ("seconds remaining : " + p0 / 1000)
                binding.guess.visibility = View.VISIBLE
            }

            override fun onFinish() {
                isRunning = false
                timer.cancel()
                binding.guess.visibility = View.GONE
                Log.d("TAG1",isRunning.toString())
            }

        }
        timer.start()
    }
    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentQuestion-1]
        if(mCurrentQuestion == mQuestionsList!!.size){
            binding.sumbit.text = "FINISH"
        }else{binding.sumbit.text = "SUMBIT"}
        binding.apply {
            image.setImageResource(question.flag)
        }
        binding.guess.visibility = View.VISIBLE
        binding.progressBarr.progress = mCurrentQuestion
        binding.progresstext.text = "$mCurrentQuestion" + "/" + binding.progressBarr.max
        setCountDownTimer()


    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.sumbit -> {
                timer.cancel()
                if (binding.guess.text.toString() == "") {
                    mCurrentQuestion++
                    when {
                        mCurrentQuestion <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val Intent = Intent(this, LeaderboardActivity::class.java)
                            Intent.putExtra(QuestionsSource.CorrectAnswer, mCorrectAnswers)
                            Intent.putExtra(QuestionsSource.Username, mUsername)
                            startActivity(Intent)
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentQuestion - 1)
                    if (question!!.country != binding.guess.text.toString()) {
                        val alertDialog = AlertDialog.Builder(this)
                        alertDialog.setTitle("Incorrect")
                        alertDialog.setMessage("This flag is ${question.country}")
                        alertDialog.setPositiveButton("OK") { _, _ ->
                            Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show()
                            binding.guess.visibility = View.GONE
                        }
                        alertDialog.show()
                    } else {
                        binding.guess.visibility = View.GONE
                        mCorrectAnswers++
                        Toast.makeText(this, "CORRECT !", Toast.LENGTH_LONG).show()
                        binding.animationView.playAnimation()
                    }
                    if (mCurrentQuestion == mQuestionsList!!.size) {
                        binding.sumbit.text = "FINISH"
                    } else {
                        binding.sumbit.text = "NEXT QUESTION"
                    }
                    binding.number.text = mCorrectAnswers.toString()
                    binding.guess.setText("")
                }
            }
        }
    }
}