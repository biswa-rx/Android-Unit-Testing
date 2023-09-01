package com.example.androidunittesting.repository

import com.example.androidunittesting.model.Product
import com.example.androidunittesting.remote.ProductApi
import com.example.androidunittesting.utils.NetworkResult

class ProductRepository (private val productApi: ProductApi) {

    suspend fun getProducts(): NetworkResult<List<Product>>{
        val response = productApi.getProducts()
        return if(response.isSuccessful) {
            val  responseBody = response.body()
            if(responseBody!= null) {
                NetworkResult.Success(responseBody)
            }else{
                NetworkResult.Error("Something went wrong")
            }
        }else {
            NetworkResult.Error("Something went wrong")
        }
    }
}