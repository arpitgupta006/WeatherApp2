package com.arpit.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buEnter.setOnClickListener {
            getTheWeather()
        }
    }

    private fun getTheWeather() {
        GlobalScope.launch(Dispatchers.Main){
            val response = withContext(Dispatchers.IO){Client.api.myWeather(etZipcode.text.toString())}
            if (response.isSuccessful){
                response.body().let {res->
                    res?.weather.let {
                        runOnUiThread{
                            tvLocation.text = res?.name.toString()
                            tvMaxTemp.text = res?.main?.tempMax.toString()
                            tvMinTemp.text = res?.main?.tempMin.toString()
                          //  tvDescription.text =
                            tvVisibility.text = res?.visibility.toString()
                            tvHumidity.text = res?.main?.humidity.toString()
                            tvLatitude.text = res?.coord?.lat.toString()
                            tvLongitude.text = res?.coord?.lon.toString()
                        }
                    }

                }
            }
        }
    }
}