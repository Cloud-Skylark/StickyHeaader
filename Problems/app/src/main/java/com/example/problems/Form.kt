package com.example.problems

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Form(navController: NavController) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().offset(0.dp, (-28).dp)
    ) {

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier.height(640.dp).width(380.dp)
        ) {
           Column(
               verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.fillMaxSize()

           ) {
               Icon(
                   painter = painterResource(R.drawable.cyclone),
                   contentDescription = "icon",
                   modifier = Modifier.size(36.dp).offset(0.dp, 24.dp),
                   Color(color = 0xFF0000FF)
               )
               Text(
                   text = "Login to Sparq",
                   fontSize = 28.sp,
                   modifier = Modifier.offset(0.dp, 36.dp),
                   style = MaterialTheme.typography.headlineMedium,
                   fontWeight = FontWeight.Bold
               )
               Spacer(modifier = Modifier.padding(55.dp))
               val mail = remember { mutableStateOf("") }
               OutlinedTextField(
                   value = mail.value,
                   onValueChange = { mail.value = it},
                   placeholder = { Text("examplename@gmail.com") },
                   label = { Text("Email") },
                   leadingIcon = {
                       Icon(
                           imageVector = Icons.Default.Email,
                           contentDescription = null
                       )
                   },
                   modifier = Modifier.fillMaxWidth()
                       .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
               )
               val password = remember { mutableStateOf("") }
               OutlinedTextField(
                   value = password.value,
                   onValueChange = { password.value = it},
                   placeholder = { Text("A-z, 0-9, @, #, $, %") },
                   label = { Text("Password") },
                   visualTransformation = PasswordVisualTransformation(),
                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                   maxLines = 1,
                   leadingIcon = {
                       Icon(
                           imageVector = Icons.Default.Lock,
                           contentDescription = null
                       )
                   },
                   modifier = Modifier.fillMaxWidth()
                       .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
               )
               Text(
                   text = "Forgot Password?",
                   fontSize = 12.sp,
                   color = Color.Blue,
                   fontFamily = FontFamily.SansSerif,
                   modifier = Modifier.offset(114.dp)
                       .clickable{
                           Toast.makeText(context, "Forgot password", Toast.LENGTH_SHORT).show()
                       }
               )
               Spacer(modifier = Modifier.padding(16.dp))

               Surface(
                   color = Color.Cyan,
                   shape = RoundedCornerShape(8.dp),
                   modifier = Modifier.height(60.dp).width(300.dp).padding(8.dp)
                       .background(Color.Transparent),
                   onClick = {
                       if (mail.value.isNotEmpty() && password.value.isNotEmpty())
                       {
                           navController.navigate("State/${mail.value}/${password.value}")
                       }
                       else {
                           Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                       }
                   }
               ) {
                   Box(
                       modifier = Modifier.fillMaxSize().background(
                           brush = Brush.linearGradient(colors = listOf(Color.Cyan, Color.Magenta))
                       )
                   ) {
                       Text(
                           text = "Log in",
                           modifier = Modifier.align(Alignment.Center),
                           fontWeight = FontWeight.Bold,
                           color = Color.White,
                           fontFamily = FontFamily.SansSerif
                       )
                   }
               }
               HorizontalDivider(
                   thickness = 2.dp,
                   modifier = Modifier
                       .padding(top = 16.dp, bottom = 30.dp).width(330.dp)
               )
               IconButton(
                   modifier = Modifier.height(30.dp).width(300.dp)
                       .border(2.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
                   onClick = { }
               ) {
                  Row(
                      horizontalArrangement = Arrangement.Center,
                      verticalAlignment = Alignment.CenterVertically
                  ) {
                      Icon(
                          painterResource(R.drawable.google_icon),
                          contentDescription = "google icon",
                          modifier = Modifier.size(22.dp)
                      )
                      Text(
                          text = "Continue with Google",
                          fontSize = 13.sp,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(start = 12.dp)
                      )
                  }
               }
               Spacer(modifier = Modifier.padding(16.dp))
               IconButton(
                   modifier = Modifier.height(30.dp).width(300.dp)
                       .border(2.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
                   onClick = { }
               ) {
                   Row(
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Icon(
                           painterResource(R.drawable.apple_icon),
                           contentDescription = "google icon",
                           modifier = Modifier.size(22.dp)
                       )
                       Text(
                           text = "Continue with Google",
                           fontSize = 13.sp,
                           fontWeight = FontWeight.Bold,
                           modifier = Modifier.padding(start = 12.dp)
                       )
                   }
               }
           }
        }
    }
}

