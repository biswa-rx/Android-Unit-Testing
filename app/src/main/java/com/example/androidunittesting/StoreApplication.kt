package com.example.androidunittesting

import android.app.Application
import com.example.androidunittesting.remote.ProductApi
import com.example.androidunittesting.repository.ProductRepository
import com.example.androidunittesting.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class StoreApplication: Application() {
    lateinit var productsAPI: ProductApi
    lateinit var productRepository: ProductRepository

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        productsAPI = retrofit.create(ProductApi::class.java)
        productRepository = ProductRepository(productsAPI)


    }
}