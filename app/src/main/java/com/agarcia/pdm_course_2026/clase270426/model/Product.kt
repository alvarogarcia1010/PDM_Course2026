package com.agarcia.pdm_course_2026.clase270426.model

data class Producto(
  val id: Int,
  val nombre: String,
  val precio: Double,
  val imagenUrl: String,
  val tipo: TipoProducto
)

enum class TipoProducto {
  PUPUSA,
  BEBIDA
}