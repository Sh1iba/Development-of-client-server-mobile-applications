package com.example.coffeeshop.network.repository

import com.example.coffeeshop.network.api.ApiClient
import com.example.coffeeshop.network.model.CoffeeImageResponse


class CoffeeRepository {
    suspend fun getRandomCoffeeImage(): CoffeeImageResponse {
        val response = ApiClient.coffeeApi.getRandomCoffeeImage()
        if (!response.isSuccessful) {
            throw Exception("HTTP error: ${response.code()}")
        }
        return response.body() ?: throw Exception("Empty response body")
    }

}