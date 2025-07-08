package com.greeshma.peek.data.web

import com.greeshma.peek.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PeekApi {
    @GET("search-news?country={country}&api-key={api-key}")
    suspend fun getNews(
        @Path("country") country: String,
        @Path("api-key") apiKey: String = API_KEY
    ):Response<String>
}