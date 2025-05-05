package com.example.coffeeshop.network.api

import com.example.coffeeshop.network.model.RegisterRequest
import com.example.coffeeshop.network.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>
}