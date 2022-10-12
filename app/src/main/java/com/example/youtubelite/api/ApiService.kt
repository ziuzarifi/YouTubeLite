package com.example.youtubelite.api

import com.example.youtubelite.models.SearchResponse
import com.example.youtubelite.utils.Constants.Companion.YOUTUBE_API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/")
    fun search(
        @Query("q") searchString: String,
        @Query("key") apiKey: String = YOUTUBE_API_KEY
    ) : Call<SearchResponse>
}