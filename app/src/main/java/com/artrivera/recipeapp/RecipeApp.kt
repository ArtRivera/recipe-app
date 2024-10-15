package com.artrivera.recipeapp

import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

@Serializable
object MealCategories

@Serializable
data class Second(val name: String)

@Serializable
data class MealCategoryDetail(val categoryId: String)

@Composable
fun RecipeApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MealCategories) {
        composable<MealCategories> {
            MealCategoriesScreen(modifier = Modifier.fillMaxSize()) { mealCategory ->
                navController.navigate(MealCategoryDetail(mealCategory.id))
            }
        }
        composable<Second> { backStackEntry ->
            val second: Second = backStackEntry.toRoute()
            SecondScreen(name = second.name)
        }

        composable<MealCategoryDetail>{ navBackStackEntry ->
            val mealCategoryDetail: MealCategoryDetail = navBackStackEntry.toRoute()
            MealCategoryDetailScreen(categoryId = mealCategoryDetail.categoryId)
        }

    }
}