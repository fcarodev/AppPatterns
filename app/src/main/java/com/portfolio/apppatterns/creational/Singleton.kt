package com.portfolio.apppatterns.creational

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Singleton
The Singleton pattern specifies that only a single instance of a class should exist with a global access point.
This pattern works well when modeling real-world objects with only one instance.
For example, if you have an object that makes network or database connections,
having more than one instance of the project may cause problems and mix data.
That’s why in some scenarios you want to restrict the creation of more than one instance.
 */
object RetrofitClient {

    private var instance: Api? = null
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): Api? {
        if (instance == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            instance = retrofit.create(Api::class.java)
        }
        return instance
    }
}

interface Api{
    @GET("example")
    suspend fun getExamples()
}