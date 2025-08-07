package com.example.happybirthday

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


@HiltAndroidApp
class AttendanceApp : Application()

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _selectedTab = MutableStateFlow(BottomNavItem.Home)
    val selectedTab: StateFlow<BottomNavItem> = _selectedTab.asStateFlow()

    fun updateSelectedTab(tab: BottomNavItem) {
        _selectedTab.value = tab
    }
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Schedule : BottomNavItem("schedule", Icons.Default.DateRange, "Schedule")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
    object Settings : BottomNavItem("settings", Icons.Default.Settings, "Settings")
}

@Composable
fun AttendancePortalApp(
    viewModel: MainViewModel = hiltViewModel()
) {
    val selectedTab by viewModel.selectedTab.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                val items = listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Schedule,
                    BottomNavItem.Profile,
                    BottomNavItem.Settings
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title, fontSize = 12.sp) },
                        selected = selectedTab == item,
                        onClick = { viewModel.updateSelectedTab(item) },
                        selectedContentColor = Color(0xFF2563EB),
                        unselectedContentColor = Color.Gray
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F7FA))
        ) {
            ProfileCard()
            LiveLectureCard()
            GridCards()
        }
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1633332755192-727a05c4013d?w=150",
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text("John Doe", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                    Text("Student ID: ST2023001", color = Color.Gray, fontSize = 14.sp)
                }
            }
            Box {
                Icon(Icons.Default.Notifications, "notifications", tint = Color.Gray)
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(Color.Red, CircleShape)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text("3", color = Color.White, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun LiveLectureCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        backgroundColor = Color(0xFFEFF6FF),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Live Lecture",
                color = Color(0xFF1E40AF),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1607990281513-2c110a25bd8c?w=150",
                    contentDescription = "Teacher",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text("Advanced Mathematics", fontWeight = FontWeight.Medium)
                    Text("Prof. Sarah Smith", color = Color.Gray, fontSize = 14.sp)
                    Text("10:00 AM - 11:00 AM", color = Color(0xFF2563EB), fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
fun GridCards() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            GridCard(
                icon = Icons.Default.DateRange,
                title = "Theory",
                subtitle = "Daily Schedule",
                iconColor = Color(0xFF7C3AED),
                onClick = { Toast.makeText(context, "Opening theory timetable...", Toast.LENGTH_SHORT).show() }
            )
        }
        item {
            GridCard(
                icon = Icons.Default.Laptop,
                title = "Practical",
                subtitle = "Lab Schedule",
                iconColor = Color(0xFF059669),
                onClick = { Toast.makeText(context, "Opening practical timetable...", Toast.LENGTH_SHORT).show() }
            )
        }
        item {
            GridCard(
                icon = Icons.Default.Person,
                title = "Attendance",
                subtitle = "Subject-wise",
                iconColor = Color(0xFF2563EB),
                onClick = { Toast.makeText(context, "Opening attendance...", Toast.LENGTH_SHORT).show() }
            )
        }
        item {
            GridCard(
                icon = Icons.Default.Assignment,
                title = "Assignments",
                subtitle = "5 Pending",
                iconColor = Color(0xFFDC2626),
                onClick = { Toast.makeText(context, "Opening assignments...", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun GridCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    iconColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                icon,
                contentDescription = title,
                tint = iconColor,
                modifier = Modifier
                    .size(24.dp)
                    .padding(bottom = 8.dp)
            )
            Text(title, fontWeight = FontWeight.SemiBold)
            Text(subtitle, color = Color.Gray, fontSize = 14.sp)
        }
    }
}