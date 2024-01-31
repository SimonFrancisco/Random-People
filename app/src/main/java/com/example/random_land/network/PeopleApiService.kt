package com.example.random_land.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PeopleApiService {
    @GET("?results=100&noinfo&format=pretty&seed=foobar")
    suspend fun getPeople():
            PeopleRandom
}

object PeopleApi {
    val retrofitService: PeopleApiService by lazy {
        retrofit.create(PeopleApiService::class.java)
    }
}