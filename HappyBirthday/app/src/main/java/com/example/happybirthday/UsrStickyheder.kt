package com.example.happybirthday

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, showSystemUi = true, device = "spec:width=1080px,height=2424px,navigation=buttons")
private fun UsrstickyPreview() {
    UsrStickyHeader()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsrStickyHeader() {
    val sections = listOf("A", "B", "C", "D", "E", "F")
    val names = listOf(
        "Aarav", "Aditi", "Arjun",
        "Badal", "Bhavya", "Bhuvan",
        "CLoudy Skylark", "Chetan", "Chirag",
        "Dhruv", "Devansh", "Diya",
        "Ekta", "Esha", "Eshan",
        "Farhan", "Firoz", "Faiza"
    )

    val groupedNames = names.groupBy { it.first().toString() }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(all = 1.dp),
        modifier = Modifier.fillMaxWidth().padding(top = 28.dp)
    ) {
        sections.forEach { section ->
            stickyHeader {
                Text(
                    text = "Section $section",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(start = 12.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            groupedNames[section]?.let { namesInSection ->
                items(namesInSection) { name ->
                    Text(
                        text = name,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}
