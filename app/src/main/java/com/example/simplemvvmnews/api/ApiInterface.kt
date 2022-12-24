package com.example.simplemvvmnews.api

import com.example.simplemvvmnews.models.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "11bbedc333bc43c9bf77d18ef103c10d"

interface ApiInterface {

    @GET("v2/everything?apiKey=$API_KEY&lang=en")
    fun getHeadlines(@Query("q")q:String): Call<News>
}
object RetrofitServices{

    val retrofitInstance :ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInstance = retrofit.create(ApiInterface::class.java)
    }

}