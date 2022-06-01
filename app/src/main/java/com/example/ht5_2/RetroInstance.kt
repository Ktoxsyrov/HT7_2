package com.example.ht5_2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetroInstance {

    @GET("all.json")
    fun getHeroesFromApi(): Call<List<SuperHero>>

    companion object{
        private const val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"
        fun getRetroInstance(): RetroInstance{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroInstance::class.java)
        }
    }
}