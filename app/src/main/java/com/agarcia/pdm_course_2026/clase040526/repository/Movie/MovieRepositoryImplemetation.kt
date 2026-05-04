package com.agarcia.pdm_course_2026.clase040526.repository.Movie

import com.agarcia.pdm_course_2026.clase040526.dummy.dummyMovies
import com.agarcia.pdm_course_2026.clase040526.model.Movie
import kotlinx.coroutines.delay

class MovieRepositoryImplemetation : MovieRepository {
  override suspend fun getMovies(): List<Movie> {
    delay(5000)
    return dummyMovies
  }

  override suspend fun getMovieById(id: Int): Movie? {
    delay(2000)
    return dummyMovies.find { it.id == id }
  }
}