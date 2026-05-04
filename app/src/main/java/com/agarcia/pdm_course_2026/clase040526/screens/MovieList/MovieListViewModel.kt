package com.agarcia.pdm_course_2026.clase040526.screens.MovieList

import androidx.lifecycle.ViewModel
import com.agarcia.pdm_course_2026.clase040526.dummy.dummyMovies
import com.agarcia.pdm_course_2026.clase040526.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieListViewModel : ViewModel() {

  private val _movies = MutableStateFlow<List<Movie>>(dummyMovies)
  val movies = _movies.asStateFlow()


}