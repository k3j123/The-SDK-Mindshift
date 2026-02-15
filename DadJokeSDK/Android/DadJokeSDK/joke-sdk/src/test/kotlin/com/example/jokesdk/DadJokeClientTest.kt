package com.example.jokesdk

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*

class DadJokeClientTest {
    @Test
    fun `test fetch joke returns success`() = runBlocking {
        val client = DadJokeClient()
        val result = client.getRandomJoke()

        assertTrue("Result should be success", result.isSuccess)
        assertNotNull("Joke should not be null", result.getOrNull())
        println("Fetched Joke: ${result.getOrNull()}")
    }
}

