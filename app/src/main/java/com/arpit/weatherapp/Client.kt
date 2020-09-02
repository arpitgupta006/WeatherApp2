package com.arpit.weatherapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    val gson = GsonBuilder().create()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val  api = retrofit.create(RetrofitInterface::class.java)
}