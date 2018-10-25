package bonnett.kevin.weatherapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.security.auth.callback.Callback

interface WeatherAPI {
    @GET("/bins/1hb3ws")
    fun getForecast() : Call<List<Forecast>>
}

class Forecast(val high: String, val low : String)

class WeatherRetriever {
    val service : WeatherAPI

    init {
        val retroFit = Retrofit.Builder().baseUrl("https://api.myjson.com").addConverterFactory(GsonConverterFactory.create()).build()
        service = retroFit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback : retrofit2.Callback<List<Forecast>>) {
        val call = service.getForecast()
        call.enqueue(callback)
    }
}