package com.agarcia.pdm_course_2026.clase200426.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.agarcia.pdm_course_2026.clase130426.AppScaffold

@Composable
fun ProfileScreen(navigateToBack: () -> Unit) {
  AppScaffold(
    title = "My Profile Screen",
    bottomBarText = "Bottom app bar",
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(text = "Welcome to the Profile Screen!", fontSize = 24.sp)
      Button(onClick = { navigateToBack() }) {
        Text("Go Back")
      }
    }
  }
}