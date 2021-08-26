package com.kamal.islamiproject.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {
    companion object
    {
       private var retrofit:Retrofit?=null
        private fun getInstance():Retrofit
        {
            val logging = HttpLoggingInterceptor(object:HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.e("Api",message)
                }
            })
            if(retrofit==null)
            {
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client =
                    OkHttpClient.Builder().addInterceptor(interceptor).build()
                //create
                retrofit = Retrofit.Builder()
                    .client(client)
                        .baseUrl("http://api.mp3quran.net/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        fun getApis():WebServer
        {
            return getInstance().create(WebServer::class.java)
        }
    }
}