package com.example.mychatgpt.composables.data

import com.google.gson.annotations.SerializedName

data class ChatDto(
    @SerializedName("model")
    private val model: String = "text-davinci-003",

    @SerializedName("prompt")
    private val prompt: String? = null,

    @SerializedName("max_tokens")
    private val max_tokens: Int = 7,

    @SerializedName("temperature")
    private val temperature: Int = 0,
)
