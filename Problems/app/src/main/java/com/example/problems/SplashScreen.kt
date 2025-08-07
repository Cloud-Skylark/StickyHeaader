package com.example.problems
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Slash() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val img = painterResource(R.drawable.scooty_bg)
        Image(
            painter = img,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .offset(0.dp, 24.dp)
        )
        Surface(
            modifier = Modifier
                .offset(24.dp, 550.dp)
                .height(280.dp)
                .width(360.dp),
            shadowElevation = 16.dp,
            shape = RoundedCornerShape(48.dp, 0.dp, 48.dp),
            color = Color.Transparent
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Blue, Color.Cyan)
                        )
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(28.dp)
                ) {
                    Text(
                        text = stringResource(R.string.new_arrival),
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = stringResource(R.string.up_to),
                        modifier = Modifier.offset(0.dp, 8.dp)
                    )
                    val context = LocalContext.current
                    Button(
                        modifier = Modifier.offset(54.dp, 48.dp).size(200.dp, 50.dp),
                        shape = RoundedCornerShape(30.dp, 1.dp, 30.dp, 1.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        onClick = {
                            val MainActivity = null
                            //val intent = Intent(context, MainActivity::class.java)
                            //context.startActivity(intent)
                            //val i = Intent(context, ProfileCard::class.java)
                            //context.startActivity(i)
                        },
                    ) {
                        Text(
                            text = stringResource(R.string.shop_now),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true ,
    device = "spec:width=1080px,height=2400px,navigation=buttons",
    backgroundColor = 0xFFAA00FF,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO or android.content.res.Configuration.UI_MODE_TYPE_NORMAL
)

fun SlashPreview() {
    Slash()
}
