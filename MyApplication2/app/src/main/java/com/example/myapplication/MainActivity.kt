package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainAppScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Tab A", "Tab B", "Tab C", "Tab D")

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text("Top App Bar")
                }
            )
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, title ->
                    NavigationBarItem(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        label = { Text(title) },
                        icon = { Icon(Icons.Default.Favorite, contentDescription = title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            when (selectedTabIndex) {
                0 -> InteractiveListScreen()
                1 -> CenteredText(text = "Tab B")
                2 -> CenteredText(text = "Tab C")
                3 -> CenteredText(text = "Tab D")
            }
        }
    }
}

@Composable
fun CenteredText(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }
}

@Composable
fun InteractiveListScreen(modifier: Modifier = Modifier) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    var selectedItem by remember { mutableStateOf<String?>(null) }

    Column(modifier = modifier.fillMaxSize()) {
        // Top horizontal scrollable list
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) { index ->
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.LightGray)
                        .border(1.dp, Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "El ${index + 1}")
                }
            }
        }

        // Box to contain and align the vertical list
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f) // 70% of the containing Box's height
            ) {
                items(100) { index ->
                    val itemName = "Item ${index + 1}"
                    ListItem(
                        itemName = itemName,
                        isSelected = itemName == selectedItem,
                        onItemClick = { selectedItem = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenHeight * 0.03f)
                    )
                }
            }
        }
    }


    selectedItem?.let { itemName ->
        ItemDetailsDialog(
            itemName = itemName,
            onDismiss = { selectedItem = null }
        )
    }
}

@Composable
fun ListItem(
    itemName: String,
    isSelected: Boolean,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = itemName,
        modifier = modifier
            .background(if (isSelected) Color.Blue else Color.Transparent)
            .border(width = 1.dp, color = Color.White)
            .clickable { onItemClick(itemName) }
    )
}

@Composable
fun ItemDetailsDialog(
    itemName: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Item Clicked") },
        text = { Text(text = "You clicked on $itemName") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Dismiss")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainAppScreenPreview() {
    MyApplicationTheme {
        MainAppScreen()
    }
}
