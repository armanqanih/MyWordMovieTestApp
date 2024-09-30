package org.lotka.xenonx.presentation.screen.book_mark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.model.WatchListModel
import org.lotka.xenonx.domain.repository.MoviesRepository
import org.lotka.xenonx.presentation.util.UiEvent
import javax.inject.Inject

class BookMarkViewModel@Inject constructor(
    private val repository: MoviesRepository,

):ViewModel()
{

    private val _state = MutableStateFlow(BookMarkState())
    val state = _state.asStateFlow()
    private val _sharedFlow = MutableSharedFlow<UiEvent>()
    val sharedFlow = _sharedFlow.asSharedFlow()


    init {
        getAllWatchListData()
    }


    fun onEvent(event: BookMarkEvent){
        when(event){
            BookMarkEvent.onBookMarkClick -> {
                viewModelScope.launch {
                    _sharedFlow.emit(UiEvent.ShowSnakeBar("Movie Save Successfully"))
                }
            }
            BookMarkEvent.onBookMarkUnClick -> {
                viewModelScope.launch {
                    _sharedFlow.emit(UiEvent.ShowSnakeBar("Movie Remove Successfully"))
                }
            }
        }
    }




    fun getAllWatchListData() {
        viewModelScope.launch {
            repository.getAllWatchListData().collect {
                _state.update {
                    it.copy(
                        watchList = it.watchList
                    )

                }
            }
        }
    }

                  fun addToBookMark(movie: WatchListModel) {
                    viewModelScope.launch {
                        repository.insertMovieInList(movie)
                        onEvent(BookMarkEvent.onBookMarkClick)
                    }.invokeOnCompletion {
                        exist(movie.mediaId)
                    }

                }

                  fun removeFromList(id: Int) {
                    viewModelScope.launch {
                        repository.removeFromList(id)
                        onEvent(BookMarkEvent.onBookMarkUnClick)
                    }.invokeOnCompletion {
                        exist(mediaId = id)
                    }

                }

                  fun deleteList() {
                    viewModelScope.launch {
                        repository.deleteList()
                    }
                }

                 fun exist(mediaId: Int) {
                    viewModelScope.launch {
                        _state.update {
                            it.copy(
                                exist = repository.exists(mediaId = mediaId)
                            )
                        }
                    }
                }
}


