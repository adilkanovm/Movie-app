package com.example.movieapp.api

import com.example.movieapp.models.TvShowResponse
import com.example.movieapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.SHOWS)
    suspend fun getTvShows(): Response<TvShowResponse>


}