package com.example.flagsapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flagsapp.Adapters.FlagAdapter
import com.example.flagsapp.Model.QuestionsSource
import com.example.flagsapp.databinding.ActivityLeaderboardBinding
import com.google.firebase.firestore.*

class LeaderboardActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityLeaderboardBinding
    private val binding get() =  _binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : FlagAdapter
    private lateinit var userArrayList : ArrayList<Users>
    private lateinit var layoutManager: LinearLayoutManager
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLeaderboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val answers = intent.getIntExtra(QuestionsSource.CorrectAnswer,0)
        val username = intent.getStringExtra(QuestionsSource.Username)
        recyclerView = binding.recyclerView
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        userArrayList = arrayListOf()
        adapter = FlagAdapter(userArrayList)
        recyclerView.adapter = adapter
        database()
        if (username != null) {
            db.collection("Flags").document(username).set(hashMapOf("name" to username ,
                "score" to answers))
        }
        binding.finish.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
    private fun database(){
        db.collection("Flags").orderBy("score", Query.Direction.DESCENDING).addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestore Error", error.message.toString())

            }

            for (dc: DocumentChange in value?.documentChanges!!) {
                if (dc.type == DocumentChange.Type.ADDED) {
                    userArrayList.add(dc.document.toObject(Users::class.java))
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}