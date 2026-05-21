package com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository

import com.agarcia.pdm_course_2026.clase220426.data.api.KtorClient
import com.agarcia.pdm_course_2026.clase220426.data.api.Movies.GetMoviesResponseDto
import com.agarcia.pdm_course_2026.clase220426.data.api.Movies.MovieDto
import com.agarcia.pdm_course_2026.clase220426.data.api.Movies.toModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiRepository : MovieRepository {
  override suspend fun getMovies(): List<com.agarcia.pdm_course_2026.clase220426.model.Movie> {
    val response: GetMoviesResponseDto = KtorClient.client.get("movie/popular") {
      parameter("language", "es-ES")
      parameter("page", 1)
    }.body()

    return response.results.map { movieDto -> movieDto.toModel() }
  }

  override suspend fun getMovieById(id: Int): com.agarcia.pdm_course_2026.clase220426.model.Movie? {
    val response: MovieDto = KtorClient.client.get("movie/$id") {
      parameter("language", "es-ES")
    }.body()

    return response.toModel()
  }
}
