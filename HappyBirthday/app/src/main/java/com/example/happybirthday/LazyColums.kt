package com.example.happybirthday

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UsrLazyColums() {
    var name = listOf<String>(
        "Badal", "shreyansh", "Cloudy", "Luvika",
        "Shubham", "shrikant", "Pranav", "Sagar",
        "Dominator", "Sidhhesh", "Akira", "Aryan",
        "Mitali", "Shruti", "Shrushti"
    )
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ) {
        items(name.size) {index ->
            val context = LocalContext.current
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(16.dp),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier.padding(16.dp),
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text(
                    text = "name: ${name[index]}",
                    fontSize = 20.sp,
                    color = Color.Magenta,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)

fun LazyColumsPreview() {
    UsrLazyColums()
}