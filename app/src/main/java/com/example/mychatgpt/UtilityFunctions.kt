package com.example.mychatgpt

import androidx.annotation.DimenRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object UtilityFunctions {

    fun dimenResource(@DimenRes id: Int): Dp {
        return id.dp
    }
}
