# MyApplication2

An Android app built entirely with Jetpack Compose that showcases a multi-tab layout with interactive list components and dialogs.

## Key Concepts

- **Jetpack Compose**: Declarative UI toolkit replacing XML layouts
- **ComponentActivity + setContent**: Entry point for a Compose-based Activity
- **Edge-to-edge display**: Enabling full-screen rendering with `enableEdgeToEdge()`
- **Scaffold**: Material 3 layout structure providing slots for top bar, bottom bar, and content
- **TopAppBar**: Composable for the top application bar with custom colors
- **NavigationBar / NavigationBarItem**: Bottom navigation with selectable tabs
- **State management**: Using `remember` and `mutableStateOf` to hold and react to UI state
- **LazyColumn / LazyRow**: Efficiently rendering large scrollable vertical and horizontal lists
- **Clickable modifiers**: Handling tap events on composables with `.clickable {}`
- **AlertDialog**: Displaying a modal dialog when a list item is tapped
- **LocalConfiguration**: Reading device screen dimensions to set dynamic sizes
- **Composable previews**: Using `@Preview` to render UI in Android Studio without running the app

## Main File

`MainActivity.kt` — Sets up a themed `MainAppScreen` with four tabs. Tab A shows an `InteractiveListScreen` with a horizontal row of boxes and a vertical list of 100 items; tapping an item opens an `ItemDetailsDialog`.
