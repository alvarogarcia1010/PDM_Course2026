package com.agarcia.pdm_course_2026.clase220426.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.agarcia.pdm_course_2026.clase130426.AppScaffold
import com.agarcia.pdm_course_2026.clase220426.components.MovieItem
import com.agarcia.pdm_course_2026.clase220426.dummy.dummyMovies

@Composable
fun MovieListScreen(
  navigateToDetail: (Int) -> Unit
) {
  AppScaffold(title = "Movies") { padding ->
    LazyColumn(
      modifier = Modifier
          .fillMaxSize()
          .padding(padding)
          .padding(16.dp),
    ) {
      items(dummyMovies) { movie ->
        MovieItem(
          movie = movie,
          onClick = { navigateToDetail(movie.id) }
        )
        Spacer(modifier = Modifier.height(12.dp))
      }
    }
  }
}
