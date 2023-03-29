package com.example.mychatgpt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

                ChatScreen(
                    modifier = Modifier,
                    chatData = chatData,
                    onSend = { send(it) },
                )
            }
        }
    }

    private fun send(text: String) {
        messageList.add(
            ChatData(
                text = text,
                bubbleStyle = BubbleStyle.RECEIVER,
            ),
        )
    }
}
