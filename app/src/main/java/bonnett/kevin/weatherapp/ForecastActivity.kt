package bonnett.kevin.weatherapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var listView = findViewById<ListView>(R.id.forecatsListView)

        var forecastStrings = listOf("Temperature", "Weather", "Humidity")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, forecastStrings)

        listView.adapter = adapter

        var retriever = WeatherRetriever()

        val callback = object : Callback<List<Forecast>> {
            override fun onResponse(call: Call<List<Forecast>>, response: Response<List<Forecast>>) {
                println(response?.body())

                for (forecastDay in response!!.body()!!) {
                    println("High: ${forecastDay.high} Low: ${forecastDay.low}")
                }
            }

            override fun onFailure(call: Call<List<Forecast>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        retriever.getForecast(callback)
    }

}
