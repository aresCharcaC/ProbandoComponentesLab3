package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ControladoresPart2() {
    var pagerState by remember { mutableStateOf(0) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text("Material 3 Demo") },
                navigationIcon = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = pagerState == 0,
                    onClick = { pagerState = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = pagerState == 1,
                    onClick = { pagerState = 1 }
                )
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showBottomSheet = true },
                icon = { Icon(Icons.Filled.Add, "Add") },
                text = { Text("Add") }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Elevated Card", style = MaterialTheme.typography.titleLarge)
                        Spacer(Modifier.height(8.dp))
                        Text("This is an elevated card in Material 3")
                    }
                }
            }
            item {
                FilledTonalButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Snackbar shown!")
                        }
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Show Snackbar")
                }
            }
            item {
                var sliderPosition by remember { mutableStateOf(0f) }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Slider", style = MaterialTheme.typography.titleMedium)
                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it }
                    )
                }
            }
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Progress Indicators", style = MaterialTheme.typography.titleMedium)
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                    CircularProgressIndicator()
                }
            }

            item {
                Divider()
            }
            item {
                var expanded by remember { mutableStateOf(false) }
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    TextField(
                        value = "Select an option",
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Option 1") },
                            onClick = { expanded = false }
                        )
                        DropdownMenuItem(
                            text = { Text("Option 2") },
                            onClick = { expanded = false }
                        )
                    }
                }
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("This is a Modal Bottom Sheet", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(16.dp))
                Button(onClick = { showBottomSheet = false }) {
                    Text("Close")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ControladoresPart2Preview() {
    BienvenidoAlCursoTheme {
        ControladoresPart2()

    }
}