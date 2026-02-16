package com.example.weatherwrapper

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

/**
 * Writing very simple test to validate that the api is being called and returning data
 */

class WeatherClientTest {
    private val lat = 30.2672
    private val lon = -97.7431

    private val client = WeatherClient("WeatherWrapperTest/1.0 (contact@example.com)")

    @Test
    fun `test getForecast returns valid data for Austin`() = runBlocking {
        val result = client.getForecast(lat, lon)

        assertTrue("API call should be successful", result.isSuccess)

        val forecast = result.getOrNull()
        assertNotNull("Forecast list should not be null", forecast)

        assertTrue("Should have multiple forecast periods", forecast!!.isNotEmpty())
        
        val firstPeriod = forecast.first()
        assertFalse("Title should not be empty", firstPeriod.title.isEmpty())
        assertTrue("Temperature should contain a unit", firstPeriod.temperature.contains("F") || firstPeriod.temperature.contains("C"))

        println("Success! Current Forecast: ${firstPeriod.title} - ${firstPeriod.temperature} - ${firstPeriod.condition}")
    }

    @Test
    fun `test getForecast returns failure for invalid coordinates`() = runBlocking {
      val result = client.getForecast(0.0, 0.0)

      assertTrue("Should return failure for non-US coordinates", result.isFailure)
    }
}