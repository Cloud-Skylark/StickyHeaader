package com.example.happybirthday

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Buttons(navController: NavController) { // isey NavControllre mese pass kiya hai
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().offset(0.dp, 120.dp)
    ) {
        Button(
            onClick = {
                // Jab Button click hoga toh Test wali scren par jayga
                navController.navigate("Test")
            }
        ) {
            Text(text = "simple Button")
            // Slider Button he Setting Reset Krne ke Liye
        }
        OutlinedButton(onClick = {}) {
            Text(text = "Outlined Button")
            // Attendace Sheet Add Krne ke Liye
        }
        TextButton(onClick = {}) {
            Text(text = "Text Button")
            // Log out krne ke Liye
        }
        FilledTonalButton(
            onClick = {}
        ) { Text("Tonal Button")}
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Filled.Favorite,
                contentDescription ="null",
                tint = Color.Red,
                modifier = Modifier.size(150.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            var checked by remember { mutableStateOf(true) }
            Text("ChecckBox")
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            var checked by remember { mutableStateOf(true) }
            Text("Switch")
            Switch(
                checked = checked,
                onCheckedChange = {checked = it}
            )
        }
        Surface(
            color = Color.LightGray,
            modifier = Modifier.height(50.dp).width(150.dp),
            shape = RoundedCornerShape(4.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                    colors = listOf(Color.Cyan, Color.Magenta)
                )),
            ){Text("Gradient Button", textAlign = TextAlign.Center)}
        }
    }
}