package com.norm.mycachinglru

import android.util.LruCache
import com.norm.mycachinglru.ProductsCache.Keys.ProductKey

object ProductsCache {

    private object Keys {
        const val ProductKey = "products"
    }

    private val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
    private val cacheSize = maxMemory / 8

    private val cache = LruCache<String, List<Product>>(cacheSize)

    fun saveProducts(products: List<Product>) {
        cache.put(ProductKey, products)
    }

    fun getProducts(): List<Product>? {
        return cache[ProductKey]
    }
}