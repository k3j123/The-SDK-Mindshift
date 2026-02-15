package com.example.jokesdk

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeService {
    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getJoke(): DadJokeResponse
}

class DadJokeClient {
    private val service: DadJokeService by lazy {
      Retrofit.Builder()
        .baseUrl("https://icanhazdadjoke.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(DadJokeService::class.java)
    }

    suspend fun getRandomJoke(): Result<String> {
      return try {
        val response = service.getJoke()
        Result.success(response.joke)
      } catch (e: Exception) {
        Result.failure(e)
      }
    }
}