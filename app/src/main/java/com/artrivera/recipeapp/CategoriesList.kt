package com.artrivera.recipeapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoriesList(mealCategories: List<MealCategory>, onPress: (mealCategory: MealCategory) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(mealCategories.size) { index ->
            CategoryItem(mealCategories[index]){
                onPress(mealCategories[index])
            }
        }
    }
}