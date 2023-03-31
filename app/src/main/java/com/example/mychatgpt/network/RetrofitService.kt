package com.example.mychatgpt.network

import com.example.mychatgpt.composables.data.ChatDto
import com.example.mychatgpt.composables.data.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitService {
    @POST(".")
    fun sendChat(
        @Body chatDto: ChatDto,
        @Header("Authorization") header: String,
    ): Call<ChatResponse>
}
