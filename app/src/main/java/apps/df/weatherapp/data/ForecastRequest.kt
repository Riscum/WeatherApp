package apps.df.weatherapp.data

import com.google.gson.Gson
import java.net.URL

class ForecastRequest (val zipCode: String){

    companion object {
        private val APP_ID = "deeed390daadbd349c3f3dfdf930b36d"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
        "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult{
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}