package com.example.happybirthday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme



//class Rowx {}

 /*   @Composable
    fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
        Row {
            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
            )
            Text(
                text = from,
                fontSize = 36.sp,
            )
        }
    }
*/
@Composable
 fun GreetingTextx(message: String, from: String, modifier: Modifier = Modifier) {
     Column(
         verticalArrangement = Arrangement.Center,
         modifier = modifier.
         padding(8.dp)
     )
     {
         Text(
             text = message,
             fontSize = 80.sp,
             lineHeight = 116.sp,
             textAlign = TextAlign.Center,
         )
         Text(
             text = from,
             fontSize = 36.sp,
             modifier = Modifier.
             padding(16.dp).
             align(alignment = Alignment.CenterHorizontally),
         )
     }
 }

@Composable
@Preview(showBackground = true)
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        //GreetingText("Happy Birthday Badal!", "from = Cloudy")
        GreetingImage(
            message = "Happy Birthday Badal!",
            from = "From Cloudy",
        )
    }
}
