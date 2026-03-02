# Android Learning Projects

A collection of Android and Kotlin projects covering core concepts from beginner fundamentals to intermediate Android development.

---

## Projects Overview

| Project | Focus | Level |
|---|---|---|
| [KotlinBasics](#kotlinbasics) | Kotlin language fundamentals | Beginner |
| [MyApplication](#myapplication) | Hello World / project setup | Beginner |
| [MyApplication3](#myapplication3) | Kotlin console practice | Beginner |
| [Views](#views) | Jetpack Compose basics | Beginner |
| [RandomNumber](#randomnumber) | Placeholder | — |
| [MyApplication5](#myapplication5) | Placeholder | — |
| [LotteryRandom](#lotteryrandom) | Intents, Sensors, Sharing | Intermediate |
| [MyApplication2](#myapplication2) | Jetpack Compose UI & State | Intermediate |
| [MyApplication4](#myapplication4) | Fragments & Navigation Component | Intermediate |
| [Planets](#planets) | Custom Adapters & Fragment Lifecycle | Intermediate |

---

## KotlinBasics

**Kotlin language fundamentals — no Android framework.**

### Key Concepts
- Variable declaration with `val` and `var`
- String interpolation using `$` and `${}`
- Basic arithmetic operations
- Console output with `println()`
- Entry point: `fun main()`

### Files
- `HelloKotlin.kt` — prints "Hello Kotlin" to console
- `Practice.kt` — variable declarations and string operations

---

## MyApplication

**Standard Android project template.**

### Key Concepts
- `AppCompatActivity` as the base class
- `setContentView()` to attach a layout
- `ConstraintLayout` as the root view
- `TextView` for displaying static text

---

## MyApplication3

**Minimal Kotlin console app.**

### Key Concepts
- Kotlin `main()` function
- `println()` output
- Basic project structure

---

## Views

**Minimal Jetpack Compose setup.**

### Key Concepts
- `ComponentActivity` with `setContent {}`
- Defining a `@Composable` function
- `Scaffold` as a base layout composable
- `@Preview` annotation for design-time previews
- Applying a custom Compose theme

---

## LotteryRandom

**Multi-screen app with sensors, intents, and data passing.**

### Key Concepts

#### Multi-Activity Navigation
- Launching a second activity with `Intent`
- Passing data between activities using `putExtra()` / `getStringExtra()`

#### Input & Validation
- `EditText` for user input
- Email format validation
- `Toast` messages for user feedback

#### Sensor API
- Accessing hardware sensors via `SensorManager`
- Implementing `SensorEventListener`
- Detecting device shake with accelerometer threshold calculation
- Registering and unregistering listeners in `onResume()` / `onPause()`

#### Random Number Generation
- `Random.nextLong()` to generate a lottery number

#### Sharing / Implicit Intents
- Composing an email with `Intent.ACTION_SEND`
- Setting MIME type, subject, and body via intent extras
- Handling missing email app gracefully with `ActivityNotFoundException`

#### Modern Display
- Edge-to-edge display with `WindowCompat`
- `ViewCompat.setOnApplyWindowInsetsListener()` for inset handling

---

## MyApplication2

**Modern UI built entirely with Jetpack Compose.**

### Key Concepts

#### Compose Fundamentals
- `@Composable` functions as the building block of UI
- `Scaffold` with `TopAppBar` and `BottomBar`
- `NavigationBar` and `NavigationBarItem` for tab switching

#### State Management
- `remember {}` to retain state across recompositions
- `mutableStateOf()` for observable state
- Reacting to state changes to update UI

#### Lazy Layouts
- `LazyRow` — horizontally scrollable list
- `LazyColumn` — vertically scrollable list with 100 items
- `items()` lambda for rendering list content

#### Interaction
- Click handlers on list items
- Selection highlighting with conditional color changes
- `AlertDialog` to show item details on tap

#### Layout & Theming
- `LocalConfiguration` to read screen dimensions
- Dynamic sizing based on screen height
- Custom colors and typography

---

## MyApplication4

**Fragment-based architecture with the Navigation Component.**

### Key Concepts

#### View Binding
- Enabling `viewBinding` in `build.gradle`
- Inflating binding in `onCreateView()`
- Null-safe binding pattern (`_binding` / `binding`)

#### Fragment Basics
- Extending `Fragment`
- `onCreateView()` for layout inflation
- `onViewCreated()` for view interaction setup

#### Navigation Component
- `NavHostFragment` as the navigation container
- `NavController` for programmatic navigation
- `findNavController().navigate(R.id.action_...)` to move between destinations
- Navigation graph XML (`nav_graph.xml`)

#### Layouts Used
- `CoordinatorLayout` — top-level container for Material behaviors
- `RelativeLayout` — position views relative to each other or parent
- `LinearLayout` — stack views horizontally or vertically
- `NestedScrollView` — scrollable container compatible with CoordinatorLayout

#### UI Components
- `EditText` with focus listener for hint management
- `ImageView` updated on button click
- `Toast` feedback on form submission

---

## Planets

**ListView with custom adapter, Fragment lifecycle, and dynamic fragment switching.**

### Key Concepts

#### Data Modeling
- Kotlin `data class` (`Planet`) with properties: `name`, `position`, `image`
- Creating a list of objects to drive UI

#### Custom Adapter
- Extending `BaseAdapter`
- Implementing `getCount()`, `getItem()`, `getItemId()`, `getView()`
- Inflating a custom item layout (`item_list_layout.xml`) in `getView()`
- View recycling with `convertView` null-check pattern
- Binding data to `TextView` and `ImageView` inside each item

#### ListView
- Attaching a custom adapter to `ListView`
- Displaying a list of model objects with rich item layouts

#### Fragment Lifecycle (All Callbacks)
- `onAttach()` — fragment attached to its context
- `onCreate()` — fragment initialised
- `onCreateView()` — layout inflated
- `onActivityCreated()` — parent activity ready
- `onStart()` — fragment visible
- `onResume()` — fragment interactive
- `onPause()` — fragment losing focus
- `onStop()` — fragment hidden
- `onDestroyView()` — view hierarchy removed
- `onDestroy()` — fragment destroyed
- `onDetach()` — fragment detached from context

#### Dynamic Fragment Transactions
- `FragmentManager` and `FragmentTransaction`
- `replace()` to swap fragments at runtime
- `addToBackStack()` for back navigation
- `commit()` to apply the transaction

#### Material Design
- `MaterialToolbar` with custom background color
- `FrameLayout` as a fragment container

---

## Concepts Quick Reference

| Concept | Project(s) |
|---|---|
| Kotlin syntax & variables | KotlinBasics, MyApplication3 |
| Activity & setContentView | MyApplication, LotteryRandom |
| Intents & data passing | LotteryRandom |
| Toast & input validation | LotteryRandom |
| Accelerometer / SensorManager | LotteryRandom |
| Implicit intents (email/share) | LotteryRandom |
| Jetpack Compose basics | Views, MyApplication2 |
| Compose state (remember, mutableStateOf) | MyApplication2 |
| LazyRow / LazyColumn | MyApplication2 |
| AlertDialog (Compose) | MyApplication2 |
| BottomNavigationBar (Compose) | MyApplication2 |
| View Binding | MyApplication4, LotteryRandom |
| Fragments & lifecycle | MyApplication4, Planets |
| Navigation Component | MyApplication4 |
| ConstraintLayout / CoordinatorLayout | MyApplication4, LotteryRandom |
| data class | Planets |
| BaseAdapter / custom ListView | Planets |
| Fragment transactions | Planets |
| Fragment lifecycle callbacks | Planets |
