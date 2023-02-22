package com.example.hiltmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hiltmvvm.Models.Product
import com.example.hiltmvvm.Repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository) :ViewModel() {

    val productsLiveData: LiveData<List<Product>>
    get() = repository.products

    init {
        viewModelScope.launch {
            delay(10000)
            repository.getProducts()
        }
    }
}