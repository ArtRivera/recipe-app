package com.artrivera.recipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MealCategoriesScreen(
    modifier: Modifier = Modifier,
    navigateToSecondScreen: (mealCategory: MealCategory) -> Unit,
) {
    val viewModel = viewModel<MainViewModel>()
    Scaffold(modifier = modifier) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            when {
                viewModel.categoryState.isLoading -> {
                    CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
                }

                viewModel.categoryState.error != null -> {
                    // Show error
                    Text("Error: ${viewModel.categoryState.error}")

                }

                else -> {
                    // Show categories
                    CategoriesList(
                        viewModel.categoryState.categories,
                        onPress = navigateToSecondScreen
                    )


                }
            }
        }
    }
}