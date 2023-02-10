package com.rehthinkdev.chatgpt.Utils

import com.rehthinkdev.chatgpt.api.ApiService
import com.rehthinkdev.chatgpt.Model.GeneratedAnswer
import com.rehthinkdev.chatgpt.Model.RequestBody
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPrompt(message: RequestBody): GeneratedAnswer {
        return apiService.getPrompt(message)
    }
}