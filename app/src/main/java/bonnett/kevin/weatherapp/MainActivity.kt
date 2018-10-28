package bonnett.kevin.weatherapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getForecastButton = findViewById<Button>(R.id.getForecastButton)

        getForecastButton.setOnClickListener {
            var getForecastIntent = Intent(this, ForecastActivity::class.java)
            val searchText = findViewById<EditText>(R.id.searchText)
            getForecastIntent.putExtra("searchTerm", searchText.text.toString())
            startActivity(getForecastIntent)
        }

    }
}
