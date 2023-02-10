package com.rehthinkdev.chatgpt.api

import com.rehthinkdev.chatgpt.Model.GeneratedAnswer
import com.rehthinkdev.chatgpt.Model.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("completions")
    suspend fun getPrompt(@Body body: RequestBody) : GeneratedAnswer
}