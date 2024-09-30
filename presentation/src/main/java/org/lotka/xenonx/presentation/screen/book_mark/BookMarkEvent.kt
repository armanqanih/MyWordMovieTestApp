package org.lotka.xenonx.presentation.screen.book_mark

sealed class BookMarkEvent {
    object onBookMarkClick: BookMarkEvent()
    object onBookMarkUnClick: BookMarkEvent()
}