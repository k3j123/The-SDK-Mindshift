package com.example.weatherwrapper.internal

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

/**
 * Internal api call, user does not have access to this function
 */

internal interface WeatherService {
  @GET("points/{lat},{lon}")
  suspend fun getMetadata(
    @Path("lat") lat: Double,
    @Path("lon") lon: Double
  ): NwsPointsResponse

  @GET
  suspend fun getForecast(@Url url: String): NwsForecastResponse
}