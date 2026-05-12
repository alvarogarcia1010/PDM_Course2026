package com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository

import com.agarcia.pdm_course_2026.clase220426.model.Movie

interface MovieRepository {
  suspend fun getMovies(): List<Movie>
  suspend fun getMovieById(id: Int): Movie?
}