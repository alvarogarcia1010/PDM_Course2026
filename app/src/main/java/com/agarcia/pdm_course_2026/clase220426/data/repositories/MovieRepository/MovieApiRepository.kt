package com.agarcia.pdm_course_2026.clase220426.data.repositories.MovieRepository

import android.util.Log
import com.agarcia.pdm_course_2026.clase220426.data.api.KtorClient
import com.agarcia.pdm_course_2026.clase220426.data.api.dto.GetMoviesResponseDto
import com.agarcia.pdm_course_2026.clase220426.data.api.dto.MovieDto
import com.agarcia.pdm_course_2026.clase220426.data.api.dto.toModel
import com.agarcia.pdm_course_2026.clase220426.model.Movie
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiRepository : MovieRepository {
  override suspend fun getMovies(): Result<List<Movie>> {
    try {
      val response: GetMoviesResponseDto = KtorClient.client
        .get("movie/popular") {
          parameter("language", "es-SV")
          parameter("page", 1)
        }
        .body()

      return Result.success(response.results.map { apiMovie -> apiMovie.toModel() })
    } catch (e: Exception) {
      Log.e("MovieApiRepository", "Error al obtener películas: ${e.message}")
      return Result.failure(e)
    }
  }

  override suspend fun getMovieById(id: Int): Result<Movie> {
    try {
      val response: MovieDto = KtorClient.client
        .get("movie/$id") {
          parameter("language", "es-SV")
        }
        .body()

      return Result.success(response.toModel())
    } catch (e: Exception) {
      Log.e("MovieApiRepository", "Error al obtener película por ID: ${e.message}")
      return Result.failure(e)
    }
  }
}