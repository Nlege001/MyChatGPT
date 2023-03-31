package com.example.mychatgpt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.mychatgpt.composables.ChatScreen
import com.example.mychatgpt.composables.data.BubbleStyle
import com.example.mychatgpt.composables.data.ChatData
import com.example.mychatgpt.ui.theme.MyChatGPTTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: ChatViewModel

    var messageList: MutableList<ChatData> = mutableListOf()

    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ChatViewModel::class.java)

        setContent {
            MyChatGPTTheme {
                var chatData by remember { mutableStateOf(viewModel.messageList) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    ChatScreen(
                        modifier = Modifier,
                        chatData = chatData,
                        onSend = { onSend(it) },
                    )
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArray("list", messageList.toTypedArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list: Array<ChatData> = savedInstanceState.getParcelableArray("list") as Array<ChatData>
        messageList = list.toMutableList()
    }

    private fun onSend(text: String) {
        Log.d("this reaches here", "this reaches here")
        viewModel.getChatData(text)
    }
}
