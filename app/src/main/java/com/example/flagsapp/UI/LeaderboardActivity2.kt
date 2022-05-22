package com.example.flagsapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flagsapp.Adapters.FlagAdapter2
import com.example.flagsapp.Model.QuestionsSource
import com.example.flagsapp.data.FlagUsers
import com.example.flagsapp.databinding.ActivityLeaderboardBinding
import com.google.firebase.firestore.*

class LeaderboardActivity2 : AppCompatActivity() {
    private lateinit var _binding : ActivityLeaderboardBinding
    private val binding get() =  _binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : FlagAdapter2
    private lateinit var userArrayList : ArrayList<FlagUsers>
    private lateinit var layoutManager: LinearLayoutManager
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLeaderboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val answers = intent.getIntExtra(QuestionsSource.mCorrectAnswer,0)
        val username = intent.getStringExtra(QuestionsSource.mUsername)
        recyclerView = binding.recyclerView
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        userArrayList = arrayListOf()
        adapter = FlagAdapter2(userArrayList)
        recyclerView.adapter = adapter
        database()
        if (username != null) {
            db.collection("FlagUsers").document(username).set(hashMapOf("user" to username ,
                "score" to answers))
        }
        binding.finish.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
    private fun database(){
        db.collection("FlagUsers").orderBy("score", Query.Direction.DESCENDING).addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestore Error", error.message.toString())

            }

            for (dc: DocumentChange in value?.documentChanges!!) {
                if (dc.type == DocumentChange.Type.ADDED) {
                    userArrayList.add(dc.document.toObject(FlagUsers::class.java))
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}