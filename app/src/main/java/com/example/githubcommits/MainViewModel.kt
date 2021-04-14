package com.example.githubcommits

import Commit
import GithubResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubcommits.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    private var _allCommits = MutableLiveData<GithubResponse>()
    val allCommits: LiveData<GithubResponse>
        get() = _allCommits

    fun getCommits() = viewModelScope.launch {
        _allCommits.value = repository.getCommits()
        }

    init {
        getCommits()
    }

}