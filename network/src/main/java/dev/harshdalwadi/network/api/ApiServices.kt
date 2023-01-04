package dev.harshdalwadi.network.api

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {

    @GET
    suspend fun fetchData(@Url apiUrl: String): ResponseBody


    @GET
    suspend fun getImage(@Url imageUrl: String): ResponseBody?
}
