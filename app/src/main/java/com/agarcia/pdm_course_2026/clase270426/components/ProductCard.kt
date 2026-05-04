package com.agarcia.pdm_course_2026.clase270426.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.agarcia.pdm_course_2026.clase270426.model.Producto

@Composable
fun ProductCard(
  producto: Producto,
  quantity: Int,
  onClick: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick() },
    shape = RoundedCornerShape(12.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      AsyncImage(
        model = producto.imagenUrl,
        contentDescription = producto.nombre,
        modifier = Modifier
          .size(80.dp)
          .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
      )
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = producto.nombre,
          fontWeight = FontWeight.SemiBold,
          style = MaterialTheme.typography.bodyLarge
        )
        Text(
          text = "$${producto.precio}",
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.primary
        )
      }
      Badge(
        containerColor = if (quantity > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
      ) {
        Text(
          text = quantity.toString(),
          color = if (quantity > 0) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
          modifier = Modifier.padding(4.dp)
        )
      }
    }
  }
}