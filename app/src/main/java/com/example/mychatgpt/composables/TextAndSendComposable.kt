package com.example.mychatgpt.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.mychatgpt.R

@Composable
fun TextAndSendComposable(
    modifier: Modifier,
    onSend: (String) -> Unit,
) {
    Row(
        Modifier
            .background(color = Color.White)
            .fillMaxWidth(),
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            modifier = Modifier.weight(1f),
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text(
                    text = "Type here to chat with ChatGPT",
                    color = Color.Gray,
                )
            },
        )

        IconButton(
            onClick = { onSend(text.text) },
            content = {
                Image(
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "send",
                )
            },
        )
    }
}

@Preview
@Composable
private fun PreviewTextAndSendComposable() {
    TextAndSendComposable(
        modifier = Modifier,
        onSend = {},
    )
}
