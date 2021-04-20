package com.example.githubcommits.adapter

import GithubResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcommits.R

class Adapter(private var commits: GithubResponse): RecyclerView.Adapter<Adapter.AdapterHolder>() {

    inner class AdapterHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var author: TextView = itemView.findViewById(R.id.textViewName)
        var date: TextView = itemView.findViewById(R.id.textViewDate)
        var commit_msg: TextView = itemView.findViewById(R.id.textViewCommit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        return AdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.apply {
            author.text = commits[position].commit.author.name
            date.text = commits[position].commit.author.date
            commit_msg.text = commits[position].commit.message
        }

    }

    override fun getItemCount(): Int {
        return commits.size
    }
}