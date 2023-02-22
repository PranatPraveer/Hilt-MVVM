package com.example.hiltmvvm.di

import com.example.hiltmvvm.Retrofit.FakerAPI
import com.example.hiltmvvm.utils.constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesFakerAPI(retrofit: Retrofit): FakerAPI {
        return retrofit.create(FakerAPI::class.java)
    }
}