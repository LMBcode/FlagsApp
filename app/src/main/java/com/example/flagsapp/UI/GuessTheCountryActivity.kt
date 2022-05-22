package com.example.flagsapp.UI

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.flagsapp.Model.FlagQuestions
import com.example.flagsapp.Model.QuestionsSource
import com.example.flagsapp.R
import com.example.flagsapp.databinding.ActivityGuessTheCountryBinding

class GuessTheCountryActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var _binding : ActivityGuessTheCountryBinding
    private val binding get() = _binding
    private var mQuestionsList : List<FlagQuestions>? = null
    private var mCurrentQuestion = 1
    private var mSelectedOption : Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUsername : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGuessTheCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        defaultOption()
        mQuestionsList = QuestionsSource.guessFlagbyCountry()
        mUsername = intent.getStringExtra(QuestionsSource.mUsername)
        setQuestion()
        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)
        binding.sumbit.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        defaultOption()
        val question = mQuestionsList!![mCurrentQuestion-1]
        if(mCurrentQuestion == mQuestionsList!!.size){
            binding.sumbit.text = "FINISH"
        }else{binding.sumbit.text = "SUMBIT"}
        binding.apply {
            Question.text = "Select the flag of :  " + question.question
            option1.setImageResource(question.optionA)
            option2.setImageResource(question.optionB)
            option3.setImageResource(question.optionC)
            option4.setImageResource(question.optionD)
        }
        binding.option1.visibility = View.VISIBLE
        binding.option2.visibility = View.VISIBLE
        binding.option3.visibility = View.VISIBLE
        binding.option4.visibility = View.VISIBLE
        binding.progressBarr.progress = mCurrentQuestion
        binding.progresstext.text = "$mCurrentQuestion" + "/" + binding.progressBarr.max
        binding.option1.isClickable = true
        binding.option2.isClickable = true
        binding.option3.isClickable = true
        binding.option4.isClickable = true

    }
    private fun defaultOption(){
        val options = ArrayList<ImageView>()
        options.add(0,binding.option1)
        options.add(1,binding.option2)
        options.add(2,binding.option3)
        options.add(3,binding.option4)

        for(option in options){
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1 -> {
                selectedOption(binding.option1, 1)
            }
            R.id.option2 -> {
                selectedOption(binding.option2, 2)
            }
            R.id.option3 -> {
                selectedOption(binding.option3, 3)
            }
            R.id.option4 -> {
                selectedOption(binding.option4, 4)
            }
            R.id.sumbit -> {
                if(mSelectedOption == 0){
                    mCurrentQuestion ++

                    when {
                        mCurrentQuestion <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else -> {
                        val Intent = Intent(this, LeaderboardActivity2::class.java)
                        Intent.putExtra(QuestionsSource.mCorrectAnswer,mCorrectAnswers)
                        Intent.putExtra(QuestionsSource.mUsername,mUsername)
                        startActivity(Intent)
                    }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentQuestion-1)
                    if (question!!.correctAnswer != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.wrong_option_bg)
                        binding.option1.isClickable = false
                        binding.option2.isClickable = false
                        binding.option3.isClickable = false
                        binding.option4.isClickable = false
                    }

                    else{
                        mCorrectAnswers++
                        Toast.makeText(this, "CORRECT !", Toast.LENGTH_LONG).show()
                        binding.animationView.playAnimation()
                        binding.option1.isClickable = false
                        binding.option2.isClickable = false
                        binding.option3.isClickable = false
                        binding.option4.isClickable = false
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_bg)
                    if(mCurrentQuestion == mQuestionsList!!.size){
                        binding.sumbit.text = "FINISH"
                    }else{
                        binding.sumbit.text = "NEXT QUESTION"
                    }
                    mSelectedOption = 0

                }
            }
        }
    }


    private fun selectedOption(view: ImageView, selectedOptionNumber : Int){
        defaultOption()
        mSelectedOption = selectedOptionNumber
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

    private fun answerView(answer : Int, drawableView : Int) {
        val question = mQuestionsList!![mCurrentQuestion-1]
        when (answer) {
            1 -> {
                binding.option1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                binding.option2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                binding.option3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                binding.option4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}