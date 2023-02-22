package com.example.hiltmvvm.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltmvvm.Models.Product
import com.example.hiltmvvm.Retrofit.FakerAPI
import com.example.hiltmvvm.db.FakerDB
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB){

    private val _products= MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts(){
        val result=fakerAPI.getProducts()
        if(result.isSuccessful && result.body()!=null){
            fakerDB.getFakerDao().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}
