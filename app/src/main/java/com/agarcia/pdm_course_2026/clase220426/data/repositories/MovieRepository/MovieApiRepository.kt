package com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository

import android.util.Log
import com.agarcia.pdm_course_2026.BuildConfig
import com.agarcia.pdm_course_2026.clase220426.data.api.KtorClient
import com.agarcia.pdm_course_2026.clase220426.data.api.dto.GetMoviesResponseDto
import com.agarcia.pdm_course_2026.clase220426.data.api.dto.MovieDto
import com.agarcia.pdm_course_2026.clase220426.data.api.dto.toModel
import com.agarcia.pdm_course_2026.clase220426.model.Movie
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiRepository : MovieRepository {
  override suspend fun getMovies(): List<Movie> {
    Log.d("KtorClient", "API Key: ${BuildConfig.TMDB_TOKEN}")

    // 1. Hacemos la petición GET al endpoint
    val response: GetMoviesResponseDto = KtorClient.client
      .get("movie/popular") {
        parameter("language", "es-SV")
        parameter("page", 1)
      }
      .body()

    // 2. Convertimos los DTOs al modelo de dominio
    return response.results.map { apiMovie ->
      apiMovie.toModel()
    }
  }

  override suspend fun getMovieById(id: Int): Movie? {
    val response: MovieDto = KtorClient.client
      .get("movie/$id") {
        parameter("language", "es-SV")
      }
      .body()

    return response.toModel()
  }
}