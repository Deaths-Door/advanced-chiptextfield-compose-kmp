package com.deathsdoor.advancedchiptextfield

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Chip style
 */
@Stable
interface ChipStyle {
    @Composable
    fun shape(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Shape>

    @Composable
    fun borderWidth(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Dp>

    @Composable
    fun borderColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color>

    @Composable
    fun textColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color>

    @Composable
    fun cursorColor(): State<Color>

    @Composable
    fun backgroundColor(
        enabled: Boolean,
        interactionSource: InteractionSource
    ): State<Color>
}