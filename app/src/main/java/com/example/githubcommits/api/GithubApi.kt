package com.example.githubcommits.api

import Commit
import GithubResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {

    @GET("repos/rails/rails/commits")
    suspend fun getCommits(): GithubResponse
}