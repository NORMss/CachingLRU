package com.norm.mycachinglru.repository

import android.util.Log
import com.norm.mycachinglru.Product
import com.norm.mycachinglru.ProductAPI
import com.norm.mycachinglru.ProductsCache

class ProductsRepositoryImpl : ProductsRepository {
    override suspend fun getProducts(): List<Product> {
        return try {
            val cacheProducts = ProductsCache.getProducts()
            if (cacheProducts == null) {
                Log.d("MyLog", "Fetching from networck")
                ProductsCache.saveProducts(
                    ProductAPI.instance.getProducts()
                )
            } else {
                Log.d("MyLog", "Fetching from cache")
            }
            ProductsCache.getProducts() ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}