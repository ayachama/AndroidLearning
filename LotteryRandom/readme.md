# LotteryRandom

An Android app demonstrating a simple login/landing screen that validates user input before navigating to a second screen.

## Key Concepts

- **View Binding**: Using `ActivityMainBinding` to access views safely without `findViewById`
- **Input validation**: Checking whether an `EditText` field is empty before proceeding
- **Toast messages**: Showing short feedback messages with `Toast.makeText()`
- **Explicit Intents**: Launching a new Activity with `Intent(this, MainActivity2::class.java)`
- **Passing data between Activities**: Attaching data to an Intent using `intent.putExtra()`

## Main File

`MainActivity.kt` — Presents an email input field and a login button. If the field is empty a Toast is shown; otherwise the app navigates to `MainActivity2` with the entered email passed as an extra.
