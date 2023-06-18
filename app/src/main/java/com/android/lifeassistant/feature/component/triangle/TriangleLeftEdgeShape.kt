package com.android.lifeassistant.feature.component.triangle

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class TriangleLeftEdgeShape() : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val trianglePath = Path().apply {
            moveTo(x = 0f + 14, y = size.height - 10)
            lineTo(x = 0f + 14, y = size.height)
            lineTo(x = 0f + 4, y = size.height)
        }
        return Outline.Generic(path = trianglePath)
    }
}