package com.example.mychatgpt.composables.data

import com.google.gson.annotations.SerializedName

data class ChatResponse(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("object")
    val obj: String? = null,

    @SerializedName("created")
    val created: Int? = null,

    @SerializedName("model")
    val model: String? = null,

    @SerializedName("choices")
    val choices: List<Choices>? = null,

    @SerializedName("usage")
    val usage: Usage? = null,
)

data class Choices(

    @SerializedName("text")
    val text: String? = null,

    @SerializedName("index")
    private val index: Int? = null,

    @SerializedName("logprobs")
    private val logprobs: String? = null,

    @SerializedName("finish_reason")
    private val finish_reason: String? = null,
)

data class Usage(

    @SerializedName("prompt_tokens")
    private val prompt_tokens: Int? = null,

    @SerializedName("completion_tokens")
    private val completion_tokens: Int? = null,

    @SerializedName("total_tokens")
    private val total_tokens: Int? = null,
)
