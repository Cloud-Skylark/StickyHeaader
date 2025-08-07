package com.example.problems

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Tryout(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        val defaultPassword = ""
        val password = rememberSaveable { mutableStateOf("defaultPassword") }

        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it},
            label = {Text("Password")},
            placeholder = {Text("enter the password")},
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.width(200.dp).padding(top = 16.dp),
            onClick = {
                navController.navigate("Try/${password.value}") {
                    popUpTo("tryout") { inclusive = true}
                }
            }
        ) {
            Image(
                painter = painterResource(R.drawable.apple_icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

