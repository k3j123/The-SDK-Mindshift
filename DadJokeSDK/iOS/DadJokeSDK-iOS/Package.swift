// swift-tools-version: 6.2
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "DadJokeSDK-iOS",
    platforms: [
        .iOS(.v15)
    ],
    products: [
        .library(
            name: "DadJokeSDK-iOS",
            targets: ["DadJokeSDK-iOS"]
        ),
    ],
    targets: [
        .target(
            name: "DadJokeSDK-iOS"
        ),
        .testTarget(
            name: "DadJokeSDK-iOSTests",
            dependencies: ["DadJokeSDK-iOS"]
        ),
    ]
)
