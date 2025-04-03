package com.example.coffeeshop.network.api

import com.example.coffeeshop.network.model.CoffeeImageResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoffeeApiService {
    @GET("random.json")
    suspend fun getRandomCoffeeImage(): Response<CoffeeImageResponse>
}