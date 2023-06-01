package org.lotka.bp.presentation.ui.recipe_list

import org.lotka.bp.presentation.ui.home.RecipeListEvent

sealed class RecipeListEvent {

    object NewSearchEvent : RecipeListEvent()

    object NextPageEvent : RecipeListEvent()

    // restore after process death
    object RestoreStateEvent: RecipeListEvent()
}