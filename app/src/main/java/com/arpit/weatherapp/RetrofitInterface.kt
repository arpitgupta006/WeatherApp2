package com.arpit.weatherapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("weather?,in&appid=bf49411e70fd3070cede568c85d5febb&units=Metric")

    suspend fun myWeather(@Query("zipcode") zipcode:String) :Response<WeatherResponse>
}