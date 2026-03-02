# Views

A minimal Jetpack Compose project demonstrating the basic structure of a Compose-based Android application.

## Key Concepts

- **Jetpack Compose**: Declarative UI framework for building Android UIs in Kotlin
- **ComponentActivity + setContent**: Launching a Compose UI tree from an Activity
- **Edge-to-edge display**: Calling `enableEdgeToEdge()` so the app draws behind system bars
- **Scaffold**: Material 3 layout container that manages insets and provides content padding
- **Text composable**: Rendering a string on screen with the `Text()` composable
- **Modifier**: Chaining layout and style instructions (e.g., `fillMaxSize()`, `padding()`)
- **Composable functions**: Defining reusable UI components with `@Composable`
- **@Preview**: Rendering composables in Android Studio's design pane without a device

## Main File

`MainActivity.kt` — Displays a `Scaffold` containing a `Greeting` composable that renders `"Hello Android!"`.
