package com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository

import com.agarcia.pdm_course_2026.clase220426.dummy.dummyMovies
import com.agarcia.pdm_course_2026.clase220426.model.Movie
import kotlinx.coroutines.delay

class MovieApiRepository : MovieRepository {
  override suspend fun getMovies(): List<Movie> {
    delay(2000)
    return dummyMovies
  }

  override suspend fun getMovieById(id: Int): Movie? {
    delay(5000)
    return dummyMovies.find { it.id == id }
  }
}