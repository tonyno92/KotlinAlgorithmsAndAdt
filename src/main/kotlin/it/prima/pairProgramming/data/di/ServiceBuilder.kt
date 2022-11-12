package it.prima.pairProgramming.data.di

import it.prima.pairProgramming.RETROFIT_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val gsonConverter: GsonConverterFactory by lazy { GsonConverterFactory.create() }

    private val client: OkHttpClient by lazy { OkHttpClient.Builder().build() }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(gsonConverter)
            .baseUrl(RETROFIT_BASE_URL)
            .build()
    }

    fun <T> createService(service: Class<T>): T = retrofit.create(service)
}