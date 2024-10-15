package com.artrivera.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun MealCategoryDetailScreen(categoryId: String) {
    val viewModel = viewModel<MainViewModel>()

    val category = viewModel.categoryState.categories.find { it.id == categoryId } ?: return
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
//                .wrapContentSize()
                .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = category.name, style = MaterialTheme.typography.headlineMedium)
            Image(
                painter = rememberAsyncImagePainter(category.imageUrl),
                contentDescription = "Category Meal Image",
                modifier = Modifier

                    .aspectRatio(1f)
            )
            Text(
                text = category.description,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(16.dp)
            )
        }
    }
}