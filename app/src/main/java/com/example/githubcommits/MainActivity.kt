package com.example.githubcommits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcommits.adapter.Adapter
import com.example.githubcommits.repository.Repository

class MainActivity : AppCompatActivity() {

    lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val repository = Repository()
        val factory = MainViewModelFactory(repository)
        model = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        model.allCommits.observe(this, Observer {
            recyclerView.adapter = Adapter(it)
            recyclerView.setHasFixedSize(true)
        })

    }
}