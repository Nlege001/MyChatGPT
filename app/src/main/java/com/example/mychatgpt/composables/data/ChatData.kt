package com.example.mychatgpt.composables.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatData(
    val text: String = "",
    val bubbleStyle: BubbleStyle = BubbleStyle.RECEIVER,
) : Parcelable
