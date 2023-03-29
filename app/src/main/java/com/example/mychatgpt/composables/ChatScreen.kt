package com.example.mychatgpt.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mychatgpt.composables.data.BubbleStyle
import com.example.mychatgpt.composables.data.ChatData

@Composable
fun ChatScreen(
    modifier: Modifier,
    chatData: List<ChatData>,
    onSend: (String) -> Unit,
) {
    var chat by remember { mutableStateOf(chatData) }

    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = Color.LightGray),
        ) {
            items(chat) {
                when (it.bubbleStyle) {
                    BubbleStyle.SENDER -> {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                        ) {
                            TextBubble(
                                modifier = Modifier,
                                bubbleStyle = BubbleStyle.SENDER,
                                text = it.text,
                            )
                        }
                    }

                    BubbleStyle.RECEIVER -> {
                        TextBubble(
                            modifier = Modifier,
                            bubbleStyle = BubbleStyle.RECEIVER,
                            text = it.text,
                        )
                    }
                }
            }
        }

        TextAndSendComposable(
            modifier = Modifier.fillMaxWidth(),
            onSend = onSend,
        )
    }
}

@Preview
@Composable
private fun PreviewChatScreen() {
    ChatScreen(
        modifier = Modifier,
        chatData = listOf(
            ChatData(
                text = "Thanks",
                bubbleStyle = BubbleStyle.SENDER,
            ),
            ChatData(
                text = "I was made in 2022 so you can say a year",
                bubbleStyle = BubbleStyle.RECEIVER,
            ),
            ChatData(
                text = "How old are you?",
                bubbleStyle = BubbleStyle.SENDER,
            ),
            ChatData(
                text = "I am not sure how to answer that",
                bubbleStyle = BubbleStyle.RECEIVER,
            ),
            ChatData(
                text = "Can humans make robots",
                bubbleStyle = BubbleStyle.SENDER,
            ),
            ChatData(
                text = "I am an AI made by openAI",
                bubbleStyle = BubbleStyle.RECEIVER,
            ),
            ChatData(
                text = "What are you?",
                bubbleStyle = BubbleStyle.SENDER,
            ),
            ChatData(
                text = "1 + 1 is 2",
                bubbleStyle = BubbleStyle.RECEIVER,
            ),
            ChatData(
                text = "What is 1 + 1",
                bubbleStyle = BubbleStyle.SENDER,
            ),
            ChatData(
                text = "Hi, I am ChatGPT! how can I help you?",
                bubbleStyle = BubbleStyle.RECEIVER,
            ),

        ),
        onSend = {},
    )
}
