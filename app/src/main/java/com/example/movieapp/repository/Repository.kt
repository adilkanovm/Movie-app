package com.example.movieapp.repository

import com.example.movieapp.api.ApiService
import javax.inject.Inject

class Repository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}