# Weather Wrapper SDK
A lightweight Android Wrapper for weather.gov API

## Installation
Add to `build.gradle`;
```
  implementation("com.github.k3j123:weather-wrapper-sdk:1.0")
```

## Usage
```
  val client = WeatherClient("ImplementApp/1.0 (example@email.com)")
  
  lifecycleScope.launch {
    client.getForecast(30.2672, -97.7431).onSuccess { forecastList ->
       val tonight = forecastList.first()
       println("Tonight in Austin: ${tonight.condition}, ${tonight.temperature}")
    }
  }
```