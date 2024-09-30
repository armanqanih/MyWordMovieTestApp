package org.lotka.xenonx.presentation.screen.detail_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.model.WatchListModel
import org.lotka.xenonx.domain.repository.DetailMovieRepository
import org.lotka.xenonx.domain.repository.MoviesRepository
import org.lotka.xenonx.domain.util.Resource
import org.lotka.xenonx.presentation.util.UiEvent
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
 private val detailRepository: DetailMovieRepository,
  saveStateHandle: SavedStateHandle
):ViewModel() {

  private val _state = MutableStateFlow(DetailState())
  val state = _state.asStateFlow()




init {
    saveStateHandle.get<String>("id")?.let { id ->
      fetchMovieDetail(id)
      fetchCastMovies(id)
      fetchSimilarMovies(id)
    }

}




  fun fetchMovieDetail(id:String){
    viewModelScope.launch {
      _state.value=state.value.copy(isLoading = true)
      detailRepository.getMoviesDetails(id).collect{result->
        when(result){
          is Resource.Success -> {
             result.data?.let {movieDetail->
               _state.value = state.value.copy(
                 movieDetail = movieDetail
                 , isLoading = false
               )
             }
          }
          is Resource.Error -> {
            _state.value=state.value.copy(
              error = result.message.toString(),
              isLoading = false
            )
          }
          is Resource.Loading -> {
            _state.value=state.value.copy(
              isLoading = result.isLoading
            )
          }
        }
      }
    }
  }


  fun fetchCastMovies(id:String){
    _state.value=state.value.copy(isLoading = true)
    viewModelScope.launch {
        detailRepository.getCastMoviesRepo(id).collect{result->
          when(result){
            is Resource.Success -> {
              result.data?.let { cast ->
                _state.value = state.value.copy(
                  castList = cast.castResult,
                  isLoading = false
                )
              }
            }
            is Resource.Error -> {
              _state.value=state.value.copy(
                error = result.message.toString(),
                isLoading = false
              )
            }
            is Resource.Loading ->
              _state.value=state.value.copy(
              isLoading = result.isLoading
            )
          } } } }



  fun fetchSimilarMovies(id:String){
    _state.value=state.value.copy(isLoading = true)
       viewModelScope.launch {
         detailRepository.getSimilarMoviesRepo(id).collect{result->
           when(result){
             is Resource.Success -> {
               result.data?.let { similarMovies ->
                 _state.value = state.value.copy(
                   movies = similarMovies,
                   isLoading = false)
           }
         }

             is Resource.Error -> {
               _state.value=state.value.copy(
                 error = result.message.toString(),
                 isLoading = false
               )
             }
             is Resource.Loading -> {
               _state.value=state.value.copy(
                 isLoading = result.isLoading
               )
             }
           }
  }


       }}




}