package com.example.problems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun lazyPreview() {
    lazyColumns()
}

data class Contact(
    val name: String,
    val number: String,
    val imageRes: Int // Use resource ID for the image
)

@Composable
fun lazyColumns() {
    val contacts = remember {
        mutableListOf<Contact>(
            Contact(
                name = "Aditi Sharma",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Badal Ahire",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Cloud Skylark",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Dominator",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Ishika Saxena",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Shreyansh Maurya",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Shrikant Dehshmukh",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Luvika Skylark",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            ),
            Contact(
                name = "Shubham ulhale",
                number = "0987654321",
                imageRes = R.drawable.me_ic
            )
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(contacts) { contact ->
            Card(
                elevation = CardDefaults.cardElevation(16.dp),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(500.dp, 130.dp).padding(4.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = contact.imageRes),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp).padding(end = 16.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = contact.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        Text(
                            text = contact.number,
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                    }
                }
            }
        }
    }
}
