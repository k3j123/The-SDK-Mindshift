import XCTest
@testable import DadJokeSDK_iOS

final class DadJokeSDKTests: XCTestCase {
    func testFetchJoke() async throws {
        let client = DadJokeClient()
        let joke = try await client.getRandomJoke()
        print("Fetched Joke: \(joke)")
        XCTAssertFalse(joke.isEmpty)
    }
}