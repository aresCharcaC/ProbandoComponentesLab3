package com.example.bienvenidoalcurso.ui.EjemplosLab3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme
import kotlinx.coroutines.launch

@Composable
fun ControladoresPart1() {
    var showDialog by remember { mutableStateOf(false) }
    var showDropDownMenu by remember { mutableStateOf(false) }
    var sliderPosition by remember { mutableStateOf(0f) }
    var switchChecked by remember { mutableStateOf(false) }
    var checkboxChecked by remember { mutableStateOf(false) }
    var radioButtonSelected by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Controladores Parte1") },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = true,
                    onClick = { /* TODO */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                    label = { Text("Info") },
                    selected = false,
                    onClick = { /* TODO */ }
                )
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    elevation = 4.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Card Content")
                        Checkbox(
                            checked = checkboxChecked,
                            onCheckedChange = { checkboxChecked = it }
                        )
                    }
                }
            }
            item {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                        contentDescription = "Sample Image"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator()
                }
            }
            item {
                Column(modifier = Modifier.padding(8.dp)) {
                    RadioButton(
                        selected = radioButtonSelected,
                        onClick = { radioButtonSelected = !radioButtonSelected }
                    )
                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it }
                    )
                    Switch(
                        checked = switchChecked,
                        onCheckedChange = { switchChecked = it }
                    )
                }
            }
            item {
                Column(modifier = Modifier.padding(8.dp)) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* TODO */ },
                        label = { Text("Outlined TextField") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("This is a Snackbar!")
                        }
                    }) {
                        Text("Show Snackbar")
                    }
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Alert Dialog") },
            text = { Text("This is an alert dialog.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.TopEnd)) {
            IconButton(onClick = { showDropDownMenu = true }) {
                Icon(Icons.Default.Settings, contentDescription = "Open Menu")
            }
            DropdownMenu(
                expanded = showDropDownMenu,
                onDismissRequest = { showDropDownMenu = false }
            ) {
                DropdownMenuItem(onClick = { /* TODO */ }) {
                    Text("Option 1")
                }
                DropdownMenuItem(onClick = { /* TODO */ }) {
                    Text("Option 2")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ControladoresPart1Preview() {
    BienvenidoAlCursoTheme {
        ControladoresPart1()

    }
}