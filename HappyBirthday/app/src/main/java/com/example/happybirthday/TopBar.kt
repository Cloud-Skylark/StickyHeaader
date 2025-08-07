package com.example.happybirthday

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Topbarpre() {
    Topbar()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Topbar() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("WhatsApp")},
                navigationIcon = {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                },
                actions = {
                    IconButton(onClick = {Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()}) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                    }
                    var expended by remember { mutableStateOf(false)}
                    IconButton(onClick = {expended = true}) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More")
                    }
                }
            )
        }
    ) {  }
}