package com.agarcia.pdm_course_2026.clase270426

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.agarcia.pdm_course_2026.clase270426.dummy.menu
import com.agarcia.pdm_course_2026.clase270426.model.OrderItem
import com.agarcia.pdm_course_2026.clase270426.model.Producto
import com.agarcia.pdm_course_2026.clase270426.screens.MenuScreen
import com.agarcia.pdm_course_2026.clase270426.screens.OrderScreen

@Composable
fun OrderUpApp() {
  val backStack = rememberNavBackStack(Routes.Menu)
  val order = rememberSaveable { mutableStateListOf<OrderItem>() }

  fun addToOrder(producto: Producto) {
    val index = order.indexOfFirst { it.producto.id == producto.id }
    if (index >= 0) order[index] = order[index].copy(cantidad = order[index].cantidad + 1)
    else order.add(OrderItem(producto, 1))
  }

  fun removeFromOrder(producto: Producto) {
    val index = order.indexOfFirst { it.producto.id == producto.id }
    if (index < 0) return
    if (order[index].cantidad > 1) order[index] = order[index].copy(cantidad = order[index].cantidad - 1)
    else order.removeAt(index)
  }

  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull() },
    entryProvider = entryProvider {
      entry<Routes.Menu> {
        MenuScreen(
          products = menu,
          order = order,
          onAddProduct = { addToOrder(it) },
          navigateToOrder = { backStack.add(Routes.Order) }
        )
      }
      entry<Routes.Order> {
        OrderScreen(
          order = order,
          onAdd = { addToOrder(it) },
          onRemove = { removeFromOrder(it) },
          navigateBack = { backStack.removeLastOrNull() }
        )
      }
    },
    transitionSpec = {
      slideInHorizontally(
        initialOffsetX = { it },
        animationSpec = tween(500)
      ) togetherWith slideOutHorizontally(
        targetOffsetX = { -it },
        animationSpec = tween(500)
      )
    },
    popTransitionSpec = {
      slideInHorizontally(
        initialOffsetX = { -it },
        animationSpec = tween(500)
      ) togetherWith slideOutHorizontally(
        targetOffsetX = { it },
        animationSpec = tween(500)
      )
    },
    predictivePopTransitionSpec = {
      slideInHorizontally(
        initialOffsetX = { -it },
        animationSpec = tween(250)
      ) togetherWith slideOutHorizontally(
        targetOffsetX = { it },
        animationSpec = tween(250)
      )
    }
  )

}