package com.norm.mycachinglru

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductAPI {

    @GET("products")
    suspend fun getProducts(): List<Product>

    companion object {
        val instance by lazy {
            Retrofit
                .Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductAPI::class.java)
        }
    }
}