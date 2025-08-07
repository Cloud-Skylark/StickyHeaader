package com.example.problems
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true, showSystemUi = true)

fun PizzaPreview() {
    Pizza()
}
data class Menus(
    val name: String,
    val des: String,
    val image: Int
)

@Composable
fun Pizza() {
    val context = LocalContext.current
    val menus = remember { listOf(
        Menus(
            name = "Margherita",
            des = "A hugely popular margherita, with a deliciously ",
            image = R.drawable.margherit
        ),
        Menus(
            name = "Double Cheese Margherita",
            des = "The ever-popular loaded with extra cheese... oodies of it!",
            image = R.drawable.double_cheese_margherita
        ),
        Menus(
            name = "Farm House",
            des = "crisp capsicum, succulent mushrooms and tomatos",
            image = R.drawable.farmhouse
        ),
        Menus(
            name = "PEPPY PANNER",
            des = "Chunky paneer with crisp capsicum and spicy red pepper",
            image = R.drawable.peppy_paneer
        ),
        Menus(
            name = "MEXICAN GREEN WAVE",
            des = "A pizza loaded with crunchy onions, crisp capsicum.",
            image = R.drawable.mexican_green_wave
        ),
        Menus(
            name = "DELUXE VEGGIE",
            des = "Veg toppings of choice with cheese garnished withdozer",
            image = R.drawable.deluxe_veggie
        ),
        Menus(
            name = "VEG EXTRAVAGANZA",
            des = "Classic tomato and mozzarella with exotic vegetables",
            image = R.drawable.veg_extravaganz
        ),
        Menus(
            name = "CHEESE N CORN",
            des = "Cheese I Golden Corn | Cheese n Corn Pizza",
            image = R.drawable.double_cheese_margherita
        ),
        Menus(
            name = "FRESH VEGGIE",
            des = "Onion & Capsicum | Grilled Mushroom",
            image = R.drawable.fresh_veggie
        ),
        Menus(
            name = "VEGGIE PARADISE",
            des = "Goldern Corn, Black Olives, Capsicum & Red Paprika",
            image = R.drawable.digital_veggie_paradise_olo_266x265
        ),
        Menus(
            name = "PANEER MAKHANI",
            des = "Paneer and Capsicum on Makhani Sauce",
            image = R.drawable.paneer_makhni
        ),
        Menus(
            name = "Indi Tandoori Paneer",
            des = "It is hot. It is spicy. It is oh-so-Indian.",
            image = R.drawable.indian_tandoori_paneer

        )
    )
    }
    LazyColumn(
        modifier = Modifier.
        fillMaxSize().
        padding(top = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(menus) {menu ->
            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(12.dp),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(1.dp).
                size(400.dp, 100.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(id = menu.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(110.dp)
                            .padding(8.dp)
                    )
                    Column {
                        Text(
                            text = menu.name,
                            modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                        Text(
                            text = menu.des,
                            modifier = Modifier.padding(8.dp),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Default
                        )
                    }
                }
            }
        }
    }
}
