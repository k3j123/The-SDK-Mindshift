# DadJoke SDK
A lightweight Android Wrapper for icanhazdadjoke API

## Installation
Add to `build.gradle`;
```
  implementation("com.github.k3j123:DadJokeSDK:1.0")
```

## Usage
```
  val client = DadJokeClient()
  var result = client.getRandomJoke()
```