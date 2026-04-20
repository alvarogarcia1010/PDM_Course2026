package com.agarcia.pdm_course_2026.clase220426

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: NavRoutes,
)

val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Default.Home, NavRoutes.Home),
    BottomNavItem("Buscar", Icons.Default.Search, NavRoutes.Search),
    BottomNavItem("Perfil", Icons.Default.Person, NavRoutes.Profile),
)
