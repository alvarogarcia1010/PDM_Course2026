package com.agarcia.pdm_course_2026.clase200426

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.runtime.NavEntry
import androidx.compose.material3.Text
import com.agarcia.pdm_course_2026.clase200426.screens.HomeScreen
import com.agarcia.pdm_course_2026.clase200426.screens.MyProfileScreen

@Composable
fun NavigationWrapperV1() {
  val backStack = remember { mutableStateListOf<Any>(Routes.Home)}

  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull()},
    entryProvider = { key ->
      when(key) {
        is Routes.Home -> NavEntry(key) {
          HomeScreen(navigateToProfile = { id ->
            backStack.add(Routes.MyProfile(id))
          })
        }
        is Routes.MyProfile -> NavEntry(key) {
          MyProfileScreen{
            backStack.removeLastOrNull()
          }
        }
        else -> NavEntry(key = Unit) {
          Text("Error Screen")
        }
      }
    }
  )
}