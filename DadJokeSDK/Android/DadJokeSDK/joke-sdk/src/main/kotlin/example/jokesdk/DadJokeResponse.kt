package com.example.jokesdk

import com.squareup.moshi.Json

data class DadJokeResponse(
    @Json(name = "id") val id: String,
    @Json(name = "joke") val joke: String,
    @Json(name = "status") val status: Int
)