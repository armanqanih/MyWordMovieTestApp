package org.lotka.xenonx.presentation.screen.home

sealed interface HomeEvent {
    data class Paginate(val category: String) : HomeEvent
    object Navigate : HomeEvent
}