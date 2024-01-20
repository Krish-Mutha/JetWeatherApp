package com.example.jetweatherforecast.repository

import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String):DataOrException<Weather,Boolean,Exception>{
        val response = try {
            api.getWeather(query = cityQuery)
        }catch (e:Exception){
            return DataOrException(e=e)
        }
        return DataOrException(data = response)
    }
}