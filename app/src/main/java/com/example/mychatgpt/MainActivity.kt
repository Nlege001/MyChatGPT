package com.example.mychatgpt

import android.annotation.SuppressLint
import android.os.Bundle
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
import com.example.mychatgpt.composables.ChatScreen
import com.example.mychatgpt.composables.data.BubbleStyle
import com.example.mychatgpt.composables.data.ChatData
import com.example.mychatgpt.ui.theme.MyChatGPTTheme

class MainActivity : ComponentActivity() {

    var messageList: MutableList<ChatData> = mutableListOf()

    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyChatGPTTheme {
                var chatData by remember { mutableStateOf(messageList) }

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

    private fun onSend(text: String) {
        messageList.add(
            ChatData(
                text = text,
                bubbleStyle = BubbleStyle.RECEIVER,
            ),
        )
    }
}
