package com.rehthinkdev.chatgpt.Model

import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("model")
    val model: String,

    @SerializedName("prompt")
    val prompt: String,

    @SerializedName("max_tokens")
    val maxTokens: Int,

    @SerializedName("temperature")
    var temperature: Float,

    @SerializedName("top_p")
    val topP: Float,

    @SerializedName("frequency_penalty")
    val frequencyPenalty: Int,

    @SerializedName("presence_penalty")
    val presencePenalty: Int,

    @SerializedName("stop")
    val stop: String
)
