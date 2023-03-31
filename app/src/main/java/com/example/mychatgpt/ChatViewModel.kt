package com.example.mychatgpt

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mychatgpt.composables.data.BubbleStyle
import com.example.mychatgpt.composables.data.ChatData
import com.example.mychatgpt.composables.data.ChatDto
import com.example.mychatgpt.composables.data.ChatResponse
import com.example.mychatgpt.network.RetrofitClient
import com.example.mychatgpt.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatViewModel(
) : ViewModel() {

    var messageList: MutableList<ChatData> = mutableListOf()

    private val _uiState = MutableLiveData(ChatResponse())
    val uiState: MutableLiveData<ChatResponse> = _uiState

    fun getChatData(text: String): MutableList<ChatData> {
        messageList.add(
            ChatData(
                text = text,
                bubbleStyle = BubbleStyle.RECEIVER,
            ),
        )
        sendText(text = text)
        _uiState.value?.toChatData()?.let { messageList.add(it) }
        Log.d("this reaches here", "$messageList")
        return messageList
    }

    fun sendText(text: String) {
        val retroService = RetrofitClient.buildService(RetrofitService::class.java)
        val call = retroService.sendChat(ChatDto(prompt = text), "Bearer api_key")
        call.enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                if (response.isSuccessful) {
                    Log.d("this reaches here 3", "${response.body()}")
                    _uiState.postValue(response.body())
                } else {
                    Log.d("this reaches here 2", "${response.body()}")
                    _uiState.postValue(null)
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                _uiState.postValue(null)
            }
        })
    }

    private fun ChatResponse.toChatData(): ChatData {
        return ChatData(
            text = this.choices?.last()?.text ?: "",
            bubbleStyle = BubbleStyle.SENDER,
        )
    }
}
