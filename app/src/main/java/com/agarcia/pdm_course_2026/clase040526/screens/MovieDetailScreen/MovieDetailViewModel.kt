package com.agarcia.pdm_course_2026.clase040526.screens.MovieDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agarcia.pdm_course_2026.clase040526.model.Movie
import com.agarcia.pdm_course_2026.clase040526.repository.Movie.MovieRepository
import com.agarcia.pdm_course_2026.clase040526.repository.Movie.MovieRepositoryImplemetation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {
  val movieRepository: MovieRepository = MovieRepositoryImplemetation()

  private val _movie = MutableStateFlow<Movie?>(null)
  val movie = _movie.asStateFlow()

  private val _isLoading = MutableStateFlow(false)
  val isLoading = _isLoading.asStateFlow()

  fun loadMovieById(id: Int) {
    viewModelScope.launch {
      _isLoading.value = true
      _movie.value = movieRepository.getMovieById(id)
      _isLoading.value = false
    }
  }
}