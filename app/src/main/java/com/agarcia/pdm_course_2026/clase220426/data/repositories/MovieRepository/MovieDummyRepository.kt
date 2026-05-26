package com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository

import com.agarcia.pdm_course_2026.clase220426.dummy.dummyMovies
import com.agarcia.pdm_course_2026.clase220426.model.Movie
import kotlinx.coroutines.delay

class MovieDummyRepository : MovieRepository {
  override suspend fun getMovies(): Result<List<Movie>> {
    delay(2000)
    return Result.success(dummyMovies)
  }

  override suspend fun getMovieById(id: Int): Result<Movie> {
    delay(5000)
    return Result.success(dummyMovies.find { it.id == id }) as Result<Movie>
  }
}