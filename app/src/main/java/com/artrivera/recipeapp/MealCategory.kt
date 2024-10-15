package com.artrivera.recipeapp

import kotlinx.serialization.Serializable

@Serializable
data class MealCategory(
    val id: String,
    val name: String,
    val imageUrl: String,
    val description: String
)

