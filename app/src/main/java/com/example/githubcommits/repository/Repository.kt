package com.example.githubcommits.repository

import Commit
import GithubResponse
import android.util.Log
import com.example.githubcommits.api.RetrofitInstance

class Repository {
    suspend fun getCommits(): GithubResponse {
        return RetrofitInstance.api.getCommits()
    }
}