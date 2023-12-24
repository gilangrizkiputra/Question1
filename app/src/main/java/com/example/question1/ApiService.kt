package com.example.question1

import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("users?page=1&per_page=10")
    fun getUsers(): Call<ArrayList<ResponseModel>>
}