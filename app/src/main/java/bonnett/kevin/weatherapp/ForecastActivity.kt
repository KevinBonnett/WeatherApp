package bonnett.kevin.weatherapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var retriever = WeatherRetriever()

        val callback = object : Callback<Weather> {
            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                println("It failed")
            }

            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                println(response?.body()?.query?.results?.channel?.title)
                title = response?.body()?.query?.results?.channel?.title

                var forecasts = response?.body()?.query?.results?.channel?.item?.forecast

                var forecastString = mutableListOf<String>()


                if (forecasts != null) {
                    for (forecast in forecasts) {
                        var weatherString = "${forecast.day} ${forecast.date} - H: ${forecast.high} L: ${forecast.low} - ${forecast.text}"
                        forecastString.add(weatherString)
                    }
                }

                var listView = findViewById<ListView>(R.id.forecatsListView)

                var adapter = ArrayAdapter(this@ForecastActivity, android.R.layout.simple_list_item_1, forecastString)

                listView.adapter = adapter

            }


        }

        val searchTerm = intent.extras.getString("searchTerm")

        retriever.getForecast(callback, searchTerm)
    }

}
