package com.portfolio.apppatterns.behavioral

// 1
interface TransportTypeStrategy {
    fun travelMode(): String
}

// 2
class Car : TransportTypeStrategy {
    override fun travelMode(): String {
        return "Road"
    }
}

class Ship : TransportTypeStrategy {
    override fun travelMode(): String {
        return "Sea"
    }
}

class Aeroplane : TransportTypeStrategy {
    override fun travelMode(): String {
        return "Air"
    }
}

// 3
class TravellingClient(var strategy: TransportTypeStrategy) {
    fun update(strategy: TransportTypeStrategy) {
        this.strategy = strategy
    }

    fun howToTravel(): String {
        return "Travel by ${strategy.travelMode()}"
    }
}