package com.example.weatherwrapper

/**
 * This is the data class that the user can see and use in their code
 * It can be modifed if they need to add extra variables.
 */

data class WeatherForecast(
    val title: String,
    val temperature: String,
    val condition: String
)