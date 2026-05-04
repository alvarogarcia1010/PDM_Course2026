package com.agarcia.pdm_course_2026.clase270426.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.agarcia.pdm_course_2026.clase130426.AppScaffold
import com.agarcia.pdm_course_2026.clase270426.components.ProductCard
import com.agarcia.pdm_course_2026.clase270426.model.OrderItem
import com.agarcia.pdm_course_2026.clase270426.model.Producto

@Composable
fun MenuScreen(
  products: List<Producto>,
  order: List<OrderItem>,
  onAddProduct: (Producto) -> Unit,
  navigateToOrder: () -> Unit
) {
  val totalItems = order.sumOf { it.cantidad }

  AppScaffold(
    title = "Menú",
    onFabClick = navigateToOrder,
    fabIcon = {
      Text(
        text = if (totalItems > 0) "🛒 $totalItems" else "🛒",
        style = MaterialTheme.typography.labelLarge
      )
    }
  ) { padding ->
    LazyColumn(
      contentPadding = PaddingValues(
        start = 16.dp,
        end = 16.dp,
        top = padding.calculateTopPadding() + 8.dp,
        bottom = padding.calculateBottomPadding() + 8.dp
      ),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      items(products) { producto ->
        ProductCard(
          producto = producto,
          quantity = order.find { it.producto.id == producto.id }?.cantidad ?: 0,
          onClick = { onAddProduct(producto) }
        )
      }
    }
  }
}
