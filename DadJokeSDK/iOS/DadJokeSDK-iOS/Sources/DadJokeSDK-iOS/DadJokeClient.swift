import Foundation

public class DadJokeClient {
    private let url = URL(string: "https://icanhazdadjoke.com")!

    public init() {}

    @available(macOS 12.0, *)
    public func getRandomJoke() async throws -> String {
        var request = URLRequest(url: url)
        request.setValue("application/json", forHTTPHeaderField: "Accept")

        let (data, response) = try await URLSession.shared.data(for: request)

        guard let httpResponse = response as? HTTPURLResponse, httpResponse.statusCode == 200 else {
            throw NSError(domain: "NetworkError", code: 0)
        }
        
        let decodedResponse = try JSONDecoder().decode(DadJoke.self, from: data)
        return decodedResponse.joke
    }
}