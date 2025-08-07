package com.example.problems

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PracticesPreview() {
    Practices()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Practices() {
    val context = LocalContext.current
   Scaffold(
       topBar = {
           TopAppBar(
               title = { Text("WhatsApp") },
               colors = TopAppBarDefaults.largeTopAppBarColors(
                   containerColor = Color.Green,
                   titleContentColor = Color.White,
                   navigationIconContentColor = Color.White,
                   actionIconContentColor = Color.White
               ),
               actions = {
                   IconButton(onClick = {}) {
                       Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                   }
                   Box {
                       var expand by remember { mutableStateOf(false) }
                        IconButton(onClick = {expand = !expand}) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)

                        }
                       DropdownMenu(
                           expanded = expand,
                           onDismissRequest = { expand = false }
                       ) {
                           DropdownMenuItem(
                               text = {Text("Setting")},
                               onClick = {Toast.makeText(context, "Setting", Toast.LENGTH_SHORT).show()}
                           )
                       }
                   }
               },
               navigationIcon = {
                   IconButton(onClick = {}) {
                       Icon(imageVector = Icons.Filled.Face, contentDescription = "Face")
                   }
               },
           )
       },
       floatingActionButton = {
           FloatingActionButton(onClick = {}) {
               Icon(imageVector = Icons.Filled.Favorite,
                   contentDescription = null,
                   tint = Color.Red
               )
           }
       }
   ) {  }
}