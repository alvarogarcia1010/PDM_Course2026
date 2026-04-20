package com.agarcia.pdm_course_2026.clase220426

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface NavRoutes : NavKey {
    @Serializable
    data object Home : NavRoutes

    @Serializable
    data object Search : NavRoutes

    @Serializable
    data object Profile : NavRoutes
}
