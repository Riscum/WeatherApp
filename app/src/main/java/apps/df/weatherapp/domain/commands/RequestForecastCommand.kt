package apps.df.weatherapp.domain.commands

import apps.df.weatherapp.data.ForecastRequest
import apps.df.weatherapp.domain.mappers.ForecastDataMapper
import apps.df.weatherapp.domain.model.ForecastList

/**
 * Created by domingos.ferreira on 30/01/2017.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}