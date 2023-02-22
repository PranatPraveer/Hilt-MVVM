package com.example.hiltmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltmvvm.Models.Product

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products :List<Product>)

    @Query("Select * From Product")
    suspend fun getProducts():List<Product>

}