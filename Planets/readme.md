# Planets

An Android app that displays a list of planets and demonstrates Fragment navigation with a custom ListView adapter.

## Key Concepts

- **View Binding**: Using `ActivityMainBinding` to access layout views safely
- **Toolbar**: Setting a custom toolbar with `setSupportActionBar()` and hiding the default title
- **Data classes / objects**: Creating `Planet` model objects with a name, number, and drawable resource
- **Custom ArrayAdapter**: Implementing `MyCustomAdapter` to populate a `ListView` with custom planet rows (text + image)
- **ListView**: Binding a list of data to a scrollable list view via an adapter
- **Fragments**: Defining `FragmentOne` and `FragmentTwo` as independent UI modules
- **FragmentManager / FragmentTransaction**: Dynamically replacing fragments in a `FrameLayout` container using `fragmentTransaction.replace()` and `commit()`
- **Button click listeners**: Switching the displayed fragment by tapping buttons

## Main File

`MainActivity.kt` — Initializes a list of four planets, attaches a `MyCustomAdapter` to a `ListView`, and handles two buttons that swap between `FragmentOne` and `FragmentTwo` in a frame container via `loadFragment()`.
