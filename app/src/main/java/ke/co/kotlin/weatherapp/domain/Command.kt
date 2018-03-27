package ke.co.kotlin.weatherapp.domain

/**
 * Created by Amuri Bonface on 3/26/2018.
 */
public interface Command<out T> {
    fun execute():T

    data class ForecastList(val city: String, val country: String, val dailyForecast:List<Forecast>)
    data class Forecast(val date: String, val description: String, val high: Int, val low: Int)
}