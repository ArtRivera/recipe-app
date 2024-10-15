package com.artrivera.recipeapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class RecipeState(
    val categories: List<MealCategory> = listOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class MainViewModel : ViewModel() {

    var categoryState by mutableStateOf(RecipeState())
        private set

    init {
        fetchCategories()
    }


    fun fetchCategories() {

        viewModelScope.launch {
            categoryState = categoryState.copy(isLoading = true)
            try {
                val response = recipeService.getCategories()
                val networkCategories = response.categories
                val categories = networkCategories.map {
                    MealCategory(
                        id = it.idCategory,
                        name = it.strCategory,
                        imageUrl = it.strCategoryThumb,
                        description = it.strCategoryDescription
                    )
                }
                categoryState = categoryState.copy(categories = categories)
            } catch (e: Exception) {
                categoryState = categoryState.copy(error = e.message)
            } finally {
                categoryState = categoryState.copy(isLoading = false)
            }
        }

    }

}