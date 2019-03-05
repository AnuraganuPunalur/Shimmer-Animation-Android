package com.apps.anurag.androidshimmer.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *Created by anurag on 05,March,2019
 */
class Api {

    companion object {

        private var apiMethods: ApiMethods

        fun getInstance(): ApiMethods {

            return apiMethods
        }

        init {
            val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val okHttpClient = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
            val retrofit =
                Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(ApiEndPoints.BASE_URL)
                    .client(okHttpClient).build()

            apiMethods = retrofit.create(ApiMethods::class.java)
        }
    }

}