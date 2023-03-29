package com.example.mychatgpt.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mychatgpt.composables.data.BubbleStyle
import com.example.mychatgpt.custom_ui.TriangleEdgeShape

@Composable
fun TextBubble(
    modifier: Modifier,
    bubbleStyle: BubbleStyle,
    text: String,
) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp,
            ),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(
                    color = colorResource(id = bubbleStyle.backGroundColor),
                    shape = RoundedCornerShape(4.dp, 4.dp, 0.dp, 4.dp),
                ),
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(
                        vertical = 8.dp,
                        horizontal = 16.dp,
                    ),
            )
        }
        Column(
            modifier = Modifier
                .background(
                    color = colorResource(id = bubbleStyle.backGroundColor),
                    shape = TriangleEdgeShape(10),
                )
                .width(8.dp)
                .fillMaxHeight(),
        ) {
        }
    }
}

@Preview
@Composable
private fun PreviewTextBubble() {
    TextBubble(
        modifier = Modifier,
        bubbleStyle = BubbleStyle.RECEIVER,
        text = "Hello, my name is ChatGPT :)",
    )
}
