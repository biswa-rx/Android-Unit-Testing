package com.example.androidunittesting.remote

import com.example.androidunittesting.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}