package com.example.weatherwrapper.internal

import com.squareup.moshi.Json

/**
 * The purpose of an internal class is so you see it as the developer
 * of the SDK but any user will not have access to this.
 * This is good for when you have a specific implementation that you don't
 * want the user to override. It also just hides the nasty/non-pretty code
 * such as Weather.gov's complex JSON format.
 */

 /**
  * This is the model we are getting back from weather.gov. We then will transform this data into usable models for the user.
  * For this example WeatherForecast.kt will be the data class we build for the user. 
  */

internal data class NwsPointsResponse(
    val properties: GridProperties
)

internal data class GridProperties(
    @Json(name = "forecast") val forecastUrl: String
)

internal data class NwsForecastResponse(
    val properties: ForecastProperties
)

internal data class ForecastProperties(
    val periods: List<NwsPeriod>
)

internal data class NwsPeriod(
    val name: String,
    val temperature: Int,
    val temperatureUnit: String,
    val shortForecast: String
)