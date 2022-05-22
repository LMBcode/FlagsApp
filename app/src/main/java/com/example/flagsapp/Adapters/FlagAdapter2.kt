package com.example.flagsapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flagsapp.UI.Users
import com.example.flagsapp.data.FlagUsers
import com.example.flagsapp.databinding.LeaderboardLayoutBinding
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent


class FlagAdapter2(private val list : ArrayList<FlagUsers>) : RecyclerView.Adapter<FlagAdapter2.ViewHolder>(){


    class ViewHolder(val binding : LeaderboardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagAdapter2.ViewHolder {
        val binding = LeaderboardLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FlagAdapter2.ViewHolder, position: Int) {
        val current = list[position]
        holder.binding.username.text = current.user
        holder.binding.score.text = current.score.toString()
    }

    override fun getItemCount(): Int {
       return list.size
    }


}