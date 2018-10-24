package bonnett.kevin.weatherapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var listView = findViewById<ListView>(R.id.forecatsListView)

        var forecastStrings = listOf("Temperature", "Weather", "Humidity")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, forecastStrings)

        listView.adapter = adapter
    }

}
