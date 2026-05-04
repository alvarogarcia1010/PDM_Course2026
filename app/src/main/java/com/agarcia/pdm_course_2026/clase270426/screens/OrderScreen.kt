package com.agarcia.pdm_course_2026.clase270426.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.agarcia.pdm_course_2026.clase130426.AppScaffold
import com.agarcia.pdm_course_2026.clase270426.components.OrderItemCard
import com.agarcia.pdm_course_2026.clase270426.model.OrderItem
import com.agarcia.pdm_course_2026.clase270426.model.Producto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
  order: List<OrderItem>,
  onAdd: (Producto) -> Unit,
  onRemove: (Producto) -> Unit,
  navigateBack: () -> Unit
) {
  val total = order.sumOf { it.producto.precio * it.cantidad }

  AppScaffold(
    title = "Mi Orden",
    navigationIcon = {
      IconButton(onClick = navigateBack) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
      }
    },
    bottomBarText = "Total: $${"%.2f".format(total)}"
  ) { padding ->
    if (order.isEmpty()) {
      OrderEmptyState(modifier = Modifier.padding(padding))
    } else {
      LazyColumn(
        contentPadding = PaddingValues(
          start = 16.dp,
          end = 16.dp,
          top = padding.calculateTopPadding() + 8.dp,
          bottom = padding.calculateBottomPadding() + 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        items(order) { orderItem ->
          OrderItemCard(
            producto = orderItem.producto,
            qty = orderItem.cantidad,
            onAdd = { onAdd(orderItem.producto) },
            onRemove = { onRemove(orderItem.producto) }
          )
        }
      }
    }
  }
}

@Composable
private fun OrderEmptyState(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = "No hay productos en la orden",
      style = MaterialTheme.typography.bodyLarge
    )
  }
}
