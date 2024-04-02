package com.norm.mycachinglru.repository

import com.norm.mycachinglru.Product

interface ProductsRepository {

    suspend fun getProducts(): List<Product>
}