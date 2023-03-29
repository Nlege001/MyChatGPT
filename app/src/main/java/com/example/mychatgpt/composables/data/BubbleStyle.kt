package com.example.mychatgpt.composables.data

import androidx.annotation.ColorRes
import com.example.mychatgpt.R

enum class BubbleStyle(
    @ColorRes val backGroundColor: Int,
) {
    RECEIVER(backGroundColor = R.color.receiver_color),
    SENDER(backGroundColor = R.color.sender_color),
}
