package com.deathsdoor.advancedchiptextfield

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Chip text field with Material Design filled style.
 *
 * The [innerModifier] will be passed to the inner text field of the decoration box. This can be
 * used to control style, layout and interaction of the inner text field independently.
 *
 * This is a sample to constraint the height of the inner text field and makes it scrollable:
 *
 * ```kotlin
 * ChipTextField(
 *     state = ...,
 *     onSubmit = ...,
 *     modifier = Modifier,
 *     innerModifier = Modifier
 *         .heightIn(max = 100.dp)
 *         .verticalScroll(state = rememberScrollState()),
 * )
 * ```
 *
 * @see [BasicChipTextField]
 * @see [TextField]
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Chip> ChipTextField(
    state: ChipTextFieldState<T>,
    onSubmit: (value: String) -> T?,
    modifier: Modifier = Modifier,
    innerModifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    readOnlyChips: Boolean = readOnly,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    textStyle: TextStyle = LocalTextStyle.current,
    chipStyle: ChipStyle = ChipTextFieldDefaults.chipStyle(),
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    chipHorizontalSpacing: Dp = 4.dp,
    chipLeadingIcon: @Composable (chip: T) -> Unit = {},
    chipTrailingIcon: @Composable (chip: T) -> Unit = { CloseButton(state, it) },
    onChipClick: ((chip: T) -> Unit)? = null,
    onChipLongClick: ((chip: T) -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.outlinedShape,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    contentPadding: PaddingValues =
        if (label == null) {
            TextFieldDefaults.textFieldWithoutLabelPadding()
        } else {
            TextFieldDefaults.textFieldWithLabelPadding()
        }
) {
    var value by remember { mutableStateOf(TextFieldValue()) }
    val onValueChange: (TextFieldValue) -> Unit = { value = it }
    ChipTextField(
        state = state,
        onSubmit = { onSubmit(it.text) },
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        innerModifier = innerModifier,
        enabled = enabled,
        readOnly = readOnly,
        readOnlyChips = readOnlyChips,
        isError = isError,
        keyboardOptions = keyboardOptions,
        textStyle = textStyle,
        chipStyle = chipStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        chipHorizontalSpacing = chipHorizontalSpacing,
        chipLeadingIcon = chipLeadingIcon,
        chipTrailingIcon = chipTrailingIcon,
        onChipClick = onChipClick,
        onChipLongClick = onChipLongClick,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        contentPadding = contentPadding,
    )
}

/**
 * Chip text field with Material Design filled style.
 *
 * The [innerModifier] will be passed to the inner text field of the decoration box. This can be
 * used to control style, layout and interaction of the inner text field independently.
 *
 * This is a sample to constraint the height of the inner text field and makes it scrollable:
 *
 * ```kotlin
 * ChipTextField(
 *     state = ...,
 *     onSubmit = ...,
 *     modifier = Modifier,
 *     innerModifier = Modifier
 *         .heightIn(max = 100.dp)
 *         .verticalScroll(state = rememberScrollState()),
 * )
 * ```
 *
 * @see [BasicChipTextField]
 * @see [TextField]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Chip> ChipTextField(
    state: ChipTextFieldState<T>,
    value: String,
    onValueChange: (String) -> Unit,
    onSubmit: (value: String) -> T?,
    modifier: Modifier = Modifier,
    innerModifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    readOnlyChips: Boolean = readOnly,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    textStyle: TextStyle = LocalTextStyle.current,
    chipStyle: ChipStyle = ChipTextFieldDefaults.chipStyle(),
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    chipHorizontalSpacing: Dp = 4.dp,
    chipLeadingIcon: @Composable (chip: T) -> Unit = {},
    chipTrailingIcon: @Composable (chip: T) -> Unit = { CloseButton(state, it) },
    onChipClick: ((chip: T) -> Unit)? = null,
    onChipLongClick: ((chip: T) -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.outlinedShape,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    contentPadding: PaddingValues =
        if (label == null) {
            TextFieldDefaults.textFieldWithoutLabelPadding()
        } else {
            TextFieldDefaults.textFieldWithLabelPadding()
        }
) {
    // Copied from androidx.compose.foundation.text.BasicTextField.kt
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value)
    SideEffect {
        if (textFieldValue.selection != textFieldValueState.selection ||
            textFieldValue.composition != textFieldValueState.composition
        ) {
            textFieldValueState = textFieldValue
        }
    }
    var lastTextValue by remember(value) { mutableStateOf(value) }
    val mappedOnValueChange: (TextFieldValue) -> Unit = { newTextFieldValueState ->
        textFieldValueState = newTextFieldValueState

        val stringChangedSinceLastInvocation = lastTextValue != newTextFieldValueState.text
        lastTextValue = newTextFieldValueState.text

        if (stringChangedSinceLastInvocation) {
            onValueChange(newTextFieldValueState.text)
        }
    }
    ChipTextField(
        state = state,
        onSubmit = { onSubmit(it.text) },
        value = textFieldValue,
        onValueChange = mappedOnValueChange,
        modifier = modifier,
        innerModifier = innerModifier,
        enabled = enabled,
        readOnly = readOnly,
        readOnlyChips = readOnlyChips,
        isError = isError,
        keyboardOptions = keyboardOptions,
        textStyle = textStyle,
        chipStyle = chipStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        chipHorizontalSpacing = chipHorizontalSpacing,
        chipLeadingIcon = chipLeadingIcon,
        chipTrailingIcon = chipTrailingIcon,
        onChipClick = onChipClick,
        onChipLongClick = onChipLongClick,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        contentPadding = contentPadding,
    )
}

/**
 * Chip text field with Material Design filled style.
 *
 * The [innerModifier] will be passed to the inner text field of the decoration box. This can be
 * used to control style, layout and interaction of the inner text field independently.
 *
 * This is a sample to constraint the height of the inner text field and makes it scrollable:
 *
 * ```kotlin
 * ChipTextField(
 *     state = ...,
 *     onSubmit = ...,
 *     modifier = Modifier,
 *     innerModifier = Modifier
 *         .heightIn(max = 100.dp)
 *         .verticalScroll(state = rememberScrollState()),
 * )
 * ```
 *
 * @see [BasicChipTextField]
 * @see [TextField]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Chip> ChipTextField(
    state: ChipTextFieldState<T>,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onSubmit: (value: TextFieldValue) -> T?,
    modifier: Modifier = Modifier,
    innerModifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    readOnlyChips: Boolean = readOnly,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    textStyle: TextStyle = LocalTextStyle.current,
    chipStyle: ChipStyle = ChipTextFieldDefaults.chipStyle(),
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    chipHorizontalSpacing: Dp = 4.dp,
    chipLeadingIcon: @Composable (chip: T) -> Unit = {},
    chipTrailingIcon: @Composable (chip: T) -> Unit = { CloseButton(state, it) },
    onChipClick: ((chip: T) -> Unit)? = null,
    onChipLongClick: ((chip: T) -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.outlinedShape,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    contentPadding: PaddingValues =
        if (label == null) {
            TextFieldDefaults.textFieldWithoutLabelPadding()
        } else {
            TextFieldDefaults.textFieldWithLabelPadding()
        }
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.onBackground,shape) //colors.backgroundColor(enabled).value, shape)
            .indicatorLine(enabled, isError, interactionSource, colors)
    ) {
        BasicChipTextField(
            state = state,
            onSubmit = onSubmit,
            value = value,
            onValueChange = onValueChange,
            modifier = innerModifier.fillMaxWidth(),
            enabled = enabled,
            readOnly = readOnly,
            readOnlyChips = readOnlyChips,
            isError = isError,
            keyboardOptions = keyboardOptions,
            textStyle = textStyle,
            chipStyle = chipStyle,
            chipHorizontalSpacing = chipHorizontalSpacing,
            chipLeadingIcon = chipLeadingIcon,
            chipTrailingIcon = chipTrailingIcon,
            onChipClick = onChipClick,
            onChipLongClick = onChipLongClick,
            interactionSource = interactionSource,
            colors = colors,
            decorationBox = { innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(
                    value = if (state.chips.isEmpty() && value.text.isEmpty()) "" else " ",
                    innerTextField = innerTextField,
                    enabled = !readOnly,
                    singleLine = false,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    isError = isError,
                    label = label,
                    placeholder = placeholder,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    colors = colors,
                    contentPadding = contentPadding,
                )
            },
        )
    }
}