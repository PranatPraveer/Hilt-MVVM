package com.example.hiltmvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltmvvm.Models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB: RoomDatabase() {
    abstract fun getFakerDao():FakerDAO
}