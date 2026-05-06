package com.agarcia.pdm_course_2026.clase040526.screens.MovieList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.agarcia.pdm_course_2026.clase040526.components.MovieItem
import com.agarcia.pdm_course_2026.clase130426.AppScaffold

@Composable
fun MovieListScreen(
  navigateToDetail: (Int) -> Unit,
  viewModel: MovieListViewModel = viewModel()
) {
  val movies by viewModel.movies.collectAsState()
  val isLoading by viewModel.isLoading.collectAsState()

  if (isLoading) {
    AppScaffold(title = "Movies") { padding ->
      Row(
        modifier = Modifier
          .padding(padding)
          .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        CircularProgressIndicator()
        Text(
          text = "Loading movies...",
        )
      }
    }
    return
  }

  AppScaffold(title = "Movies") { padding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .padding(16.dp),
    ) {
      items(movies) { movie ->
        MovieItem(
          movie = movie,
          onClick = { navigateToDetail(movie.id) }
        )
        Spacer(modifier = Modifier.height(12.dp))
      }
    }
  }
}
