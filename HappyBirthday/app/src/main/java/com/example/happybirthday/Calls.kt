package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class Calls : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            installSplashScreen()
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CallsAllfunction()
                }
            }
        }
    }
}

@Composable
fun CallsAllfunction() {
    //States()
    //UsrLazyColums()
    //UsrLazyRows()
    //Buttons()
    //UsrStickyHeader()
    //UsrGrides()
    //InputeText()
    //Test()
    //MyAppNavController()
    //ScrollView()
    //Topbar()
    CustomCalendar()
}