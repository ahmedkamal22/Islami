package com.kamal.islamiproject.api

import retrofit2.Call
import retrofit2.http.GET

interface WebServer {

    @GET("radios/radio_arabic.json")
    fun getRadiosChannels():Call<RadioResponse>
}