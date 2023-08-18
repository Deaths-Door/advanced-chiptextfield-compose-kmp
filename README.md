# advanced-chiptextfield-compose-kmp

Discover a dynamic Editable Chip Text Field implementation for Kotlin Multiplatform Mobile (KMM) applications using Jetpack Compose. This repository showcases a versatile UI component that enables users to create chips by typing and converting text entries. Harnessing the power of Jetpack Compose, this project provides a cross-platform solution for seamlessly managing chip-like elements without the need for images or complex UI elements.

# Note

This library offers an enhanced version of [OG Repo](https://github.com/dokar3/ChipTextField/tree/main), now expanded to include Kotlin Multiplatform (KMP) compatibility alongside the improved design system of Jetpack Compose M3, which builds upon the foundations of M2.

**Key Enhancements:**

* **Kotlin Multiplatform Support:** This library now extends beyond Android, bringing the power of Jetpack Compose M3 design to both Android and other platforms, thanks to Kotlin Multiplatform (KMP) capabilities.
* **M3 Design Evolution:** Building upon the success of M2, this library incorporates the refined design principles of Jetpack Compose M3, enhancing user interface aesthetics and functionality.
* **Seamless Transition:** Integrate the library seamlessly into your existing projects using the [OG Repo](https://github.com/dokar3/ChipTextField/tree/main), whether they're based on Android M2 Compose or a multiplatform architecture.

# Usage

This library provides enhanced ChipTextField components with various styles and features. Let's explore how to use these components effectively.

### Default (Filled Style)

Use the following code snippet to create a `ChipTextField` with a default filled style:

```kotlin
var value by remember { mutableStateOf("Initial text") }
val state = rememberChipTextFieldState<Chip>()
ChipTextField(
    state = state,
    value = value,
    onValueChange = { value = it },
    onSubmit = { text -> Chip(text) },
)

```

![](/images/screenshot_filled.jpg)

### Simplified Version if not Caring about TextField Value

For situations where you don't need to explicitly track the value of the text field, use this simplified code:

```kotlin
val state = rememberChipTextFieldState<Chip>()
ChipTextField(
    state = state,
    onSubmit = ::Chip,
)
```

### Outlined Style

To create an `OutlinedChipTextField` with an outlined style, use the following code:

```kotlin
val state = rememberChipTextFieldState<Chip>()
OutlinedChipTextField(
    state = state,
    onSubmit = ::Chip,
)
```

![](/images/screenshot_outlined.jpg)

### Classic Underline Style

For a classic underline style, apply additional styling to the `ChipTextField`:

```kotlin
val state = rememberChipTextFieldState<Chip>()
ChipTextField(
    state = state,
    onSubmit = ::Chip,
    colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
    ),
    contentPadding = PaddingValues(bottom = 8.dp),
)
```

![](/images/screenshot_light.png)

## Checkable Chips

Create checkable chips using the `CheckableChip` class:

```kotlin
class CheckableChip(text: String, isChecked: Boolean = false) : Chip(text) {
    var isChecked by mutableStateOf(isChecked)
}

val state = rememberChipTextFieldState(
    chips = listOf(CheckableChip(""), /*...*/),
)
BasicChipTextField(
    state = state,
    onSubmit = { null },
    readOnly = true, // Disable editing
    chipLeadingIcon = { chip -> CheckIcon(chip) }, // Show check icon if checked
    chipTrailingIcon = {}, // Hide default close button
    onChipClick = { chip -> chip.isChecked = !chip.isChecked }
)

@Composable
fun CheckIcon(chip: CheckableChip, modifier: Modifier = Modifier) { /*...*/ }
```

![](/images/screenshot_checkable.jpg)


### Avatar Chips

Create avatar chips with the `AvatarChip` class:


```kotlin
class AvatarChip(text: String, val avatarUrl: String) : Chip(text)

val state = rememberChipTextFieldState<AvatarChip>()
ChipTextField(
    state = state,
    onSubmit = { AvatarChip(it.text, AVATAR_URL) },
    chipLeadingIcon = { chip -> Avatar(chip) } // Load and display avatar
)

@Composable
fun Avatar(chip: AvatarChip, modifier: Modifier = Modifier) { /*...*/ }
```

![](/images/screenshot_avatar.jpg)


Please note that the examples provided here are simplified and serve as a starting point. For comprehensive documentation of the crate, please visit the crate documentation for a better understanding of the crate's functionalities and APIs.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.