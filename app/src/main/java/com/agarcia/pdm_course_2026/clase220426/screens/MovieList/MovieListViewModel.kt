package com.agarcia.pdm_course_2026.clase220426.screens.MovieList

import androidx.lifecycle.ViewModel
import com.agarcia.pdm_course_2026.clase220426.dummy.dummyMovies
import com.agarcia.pdm_course_2026.clase220426.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieListViewModel : ViewModel() {
  private val _movies = MutableStateFlow<List<Movie>>(emptyList())
  val movies = _movies.asStateFlow()

  private val _loading = MutableStateFlow<Boolean>(false)
  val loading = _loading.asStateFlow()

  fun loadMovies() {
    _loading.value = true
    // Simulate loading movies from an API or database
    _movies.value = dummyMovies
    _loading.value = false
  }
}