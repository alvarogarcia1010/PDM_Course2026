package com.agarcia.pdm_course_2026.clase220426.screens.MovieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository.MovieApiRepository
import com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository.MovieRepository
import com.agarcia.pdm_course_2026.clase220426.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
  private val movieRepository: MovieRepository = MovieApiRepository()
  private val _movies = MutableStateFlow<List<Movie>>(emptyList())
  val movies = _movies.asStateFlow()

  private val _loading = MutableStateFlow<Boolean>(false)
  val loading = _loading.asStateFlow()

  private val _refresing = MutableStateFlow<Boolean>(false)
  val refresing = _refresing.asStateFlow()

  private val _error = MutableStateFlow<String?>(null)
  val error = _error.asStateFlow()

  init {
    loadMovies()
  }

  fun loadMovies() {
    viewModelScope.launch {
      _loading.value = true
      _error.value = null

      movieRepository.getMovies()
        .onSuccess { movies -> _movies.value = movies }
        .onFailure { error -> _error.value = error.message }

      _loading.value = false
    }
  }

  fun refreshMovies() {
    viewModelScope.launch {
      _refresing.value = true
      _error.value = null

      movieRepository.getMovies()
        .onSuccess { movies -> _movies.value = movies }
        .onFailure { error -> _error.value = error.message }

      _refresing.value = false
    }
  }
}