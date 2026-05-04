package com.agarcia.pdm_course_2026.clase040526.repository.Movie

import com.agarcia.pdm_course_2026.clase040526.model.Movie

interface MovieRepository {
  suspend fun getMovies(): List<Movie>
  suspend fun getMovieById(id: Int): Movie?
}