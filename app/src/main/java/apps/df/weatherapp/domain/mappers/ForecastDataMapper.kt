package apps.df.weatherapp.domain.mappers

import apps.df.weatherapp.data.Forecast
import apps.df.weatherapp.data.ForecastResult
import apps.df.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import apps.df.weatherapp.domain.model.Forecast as ModelForecast

public class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date*100)
    }

}