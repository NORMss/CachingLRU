package com.norm.mycachinglru.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norm.mycachinglru.Product
import com.norm.mycachinglru.repository.ProductsRepository
import com.norm.mycachinglru.repository.ProductsRepositoryImpl
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val productsRepository: ProductsRepository = ProductsRepositoryImpl()

    var isLoading by mutableStateOf(false)
    val products = mutableStateListOf<Product>()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            isLoading = true
            products.addAll(
                productsRepository.getProducts()
            )
            isLoading = false
        }
    }
}