package com.agarcia.pdm_course_2026.clase220426

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.agarcia.pdm_course_2026.clase220426.screens.HomeScreen
import com.agarcia.pdm_course_2026.clase220426.screens.ProfileScreen
import com.agarcia.pdm_course_2026.clase220426.screens.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    // Cada tab mantiene su propio back stack independiente
    val homeBackStack = rememberNavBackStack(NavRoutes.Home)
    val searchBackStack = rememberNavBackStack(NavRoutes.Search)
    val profileBackStack = rememberNavBackStack(NavRoutes.Profile)

    var currentTab by remember { mutableStateOf<NavRoutes>(NavRoutes.Home) }

    val activeBackStack = when (currentTab) {
        NavRoutes.Home -> homeBackStack
        NavRoutes.Search -> searchBackStack
        NavRoutes.Profile -> profileBackStack
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Clase 20/04/26 — Navigation 3") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentTab == item.route,
                        onClick = { currentTab = item.route },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavDisplay(
            backStack = activeBackStack,
            onBack = {
                if (activeBackStack.size > 1) {
                    activeBackStack.removeAt(activeBackStack.lastIndex)
                }
            },
            entryProvider = entryProvider {
                entry<NavRoutes.Home> { HomeScreen() }
                entry<NavRoutes.Search> { SearchScreen() }
                entry<NavRoutes.Profile> { ProfileScreen() }
            }
        )
    }
}
