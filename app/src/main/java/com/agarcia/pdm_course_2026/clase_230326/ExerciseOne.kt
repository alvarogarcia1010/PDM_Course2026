package com.agarcia.pdm_course_2026.clase_230326

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.agarcia.pdm_course_2026.ui.theme.PDM_Course_2026Theme

@Composable
fun ExerciseOne (modifier: Modifier = Modifier) {
  Column(modifier = modifier.fillMaxHeight()) {
    Box(modifier = Modifier.weight(1f).fillMaxWidth().background(color = Color.Cyan), contentAlignment = Alignment.Center) {
      Text(text = "Box 1")
    }
    Row(modifier = Modifier.weight(1f).fillMaxWidth()) {
      Box(Modifier.weight(1f).fillMaxHeight().background(color = Color.Red), contentAlignment = Alignment.Center) {
        Text(text = "Box 2")
      }
      Box(Modifier.weight(1f).fillMaxHeight().background(color = Color.Green), contentAlignment = Alignment.TopCenter) {
        Text(text = "Box 3")
      }
    }

    Box(modifier = Modifier.weight(1f).fillMaxWidth().background(color = Color.Magenta), contentAlignment = Alignment.BottomCenter) {
      Text(text = "Box 4")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  PDM_Course_2026Theme {
    ExerciseOne()
  }
}