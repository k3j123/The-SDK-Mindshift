# DadJoke SDK
A lightweight iOS Wrapper for icanhazdadjoke API

## Installation
Add to `Package.swift`;
```
dependencies: [
    .package(url: "https://github.com/YOUR_USERNAME/DadJokeSDK-iOS.git", from: "1.0.0")
]
```
## Usage
```
    let client = DadJokeClient()
    Task {
        do {
            let joke = try await client.getaRandomJoke()
        } catch {
            print("Error fetching joke: \(error.localizedDescription))
        }
    }
```