package com.example.flagsapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flagsapp.UI.Users
import com.example.flagsapp.databinding.LeaderboardLayoutBinding
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent


class FlagAdapter(private val list : ArrayList<Users>) : RecyclerView.Adapter<FlagAdapter.ViewHolder>(){


    class ViewHolder(val binding : LeaderboardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagAdapter.ViewHolder {
        val binding = LeaderboardLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FlagAdapter.ViewHolder, position: Int) {
        val current = list[position]
        holder.binding.username.text = current.name
        holder.binding.score.text = current.score.toString()
    }

    override fun getItemCount(): Int {
       return list.size
    }


}