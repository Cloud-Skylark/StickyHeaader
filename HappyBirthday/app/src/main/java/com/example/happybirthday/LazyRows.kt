package com.example.happybirthday

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showSystemUi = true, showBackground = true)

fun LazyRowPreview() {
    LazyRows()
}

@Composable
fun LazyRows() {
    var name = listOf<String>(
        "Badal", "shreyansh", "Cloudy", "Luvika",
        "Shubham", "shrikant", "Pranav", "Sagar",
        "Dominator", "Sidhhesh", "Akira", "Aryan",
    )
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        items(name) { name ->

            Card(
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(16.dp),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier.padding(16.dp)
                    .height(150.dp)
            ) {
                Text(
                    text = "name: $name",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Magenta
                )
            }
        }
    }
}