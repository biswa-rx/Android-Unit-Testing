package com.example.androidunittesting.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidunittesting.model.Product
import com.example.androidunittesting.repository.ProductRepository
import com.example.androidunittesting.utils.NetworkResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData<NetworkResult<List<Product>>>()
    val products: LiveData<NetworkResult<List<Product>>>
        get() = _products

    fun getProducts(){
        viewModelScope.launch {
            _products.value = NetworkResult.Loading()
            delay(10000)
            val result = repository.getProducts()
            _products.postValue(result)
        }
    }

}