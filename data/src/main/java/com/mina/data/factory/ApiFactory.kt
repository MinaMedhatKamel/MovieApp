package com.mina.data.factory

import com.mina.data.network.Api
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createEbayApi(client: OkHttpClient): Api = Retrofit
    .Builder().apply {
        client(client)
        addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        baseUrl("https://gateway.ebay-kleinanzeigen.de/coding-challenge/api/v1/")
    }
    .build()
    .create(Api::class.java)


