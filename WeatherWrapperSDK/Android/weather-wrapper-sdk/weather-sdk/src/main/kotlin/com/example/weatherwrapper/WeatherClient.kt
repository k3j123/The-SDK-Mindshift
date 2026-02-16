package com.example.weatherwrapper

import com.example.weatherwrapper.internal.WeatherService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * The main class that gets called by the user. 
 * Implementing: 
 * val client = WeatherClient("ImplementApp/1.0 (example@email.com)")
 * lifecycleScope.launch {
 *   client.getForecast(30.2672, -97.7431).onSuccess { forecastList ->
 *      val tonight = forecastList.first()
 *      println("Tonight in Austin: ${tonight.condition}, ${tonight.temperature}")
 *   }
 * }
 * 
 */

class WeatherClient(private val userAgent: String) {

	private val service: WeatherService by lazy {
		val moshi = Moshi.Builder()
			.addLast(KotlinJsonAdapterFactory())
			.build()

			Retrofit.Builder()
				.baseUrl("https://api.weather.gov/")
				.addConverterFactory(MoshiConverterFactory.create(moshi))
				.build()
				.create(WeatherService::class.java)
    }

	suspend fun getForecast(lat: Double, lon: Double): Result<List<WeatherForecast>> {
		return try {
			val metadata = service.getMetadata(lat, lon)
			val forecastUrl = metadata.properties.forecastUrl

			val response = service.getForecast(forecastUrl)

			val cleanData = response.properties.periods.map { period ->
				WeatherForecast(
					title = period.name,
					temperature = "${period.temperature} ${period.temperatureUnit}",
					condition = period.shortForecast
				)
			}
			Result.success(cleanData)
		} catch (e: Exception) {
			Result.failure(e)
		}
	}
}