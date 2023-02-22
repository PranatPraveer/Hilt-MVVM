package com.example.hiltmvvm.Retrofit

import com.example.hiltmvvm.Models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}