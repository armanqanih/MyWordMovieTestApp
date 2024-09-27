package org.lotka.xenonx.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.repository.MoviesRepository
import org.lotka.xenonx.domain.util.Category
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val repository: MoviesRepository
):ViewModel()  {

    private val _state = MutableStateFlow(HomeState())
    val state= _state.asStateFlow()


    init {
        getDiscoverMovie()
        getNowPlayingMovies(true)
        getPopularMovieList(false)
        getUpcomingMovieList(false)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.Navigate -> {
                _state.update {
                    it.copy(

                    )
                }
            }

            is HomeEvent.Paginate -> {
                if (event.category == Category.POPULAR) {
                    getPopularMovieList(true)
                } else if (event.category == Category.UPCOMING) {
                    getUpcomingMovieList(true)
                } else if (event.category == Category.NOWPLAYING) {
                    getUpcomingMovieList(true)
                }
            }
        }
    }



    private fun getDiscoverMovie(){
        viewModelScope.launch {
            repository.getDiscoverMovies(state.value.dicCoverPage).collect{result->
                _state.update { it.copy(isLoading = true) }
                when(result){
                    is Resource.Success -> {
                     result?.data.let { movies->
                         _state.update { it.copy(
                             dicCoverMovies = movies,
                             isLoading = false,
                             dicCoverPage = it.dicCoverPage + 1
                         ) }
                     }
                    }
                    is Resource.Error -> {
                        _state.update { it.copy(
                            isLoading = false
                            , error = result.message
                        )}
                    }
                    is Resource.Loading -> {
                        _state.update { it.copy(isLoading = true) }
                    }

                }
            }
        }
    }


    private fun getNowPlayingMovies(forceFetchFromRemote: Boolean){
        viewModelScope.launch {
            repository.getNowPlayingMovies(fromFetchForRemote = forceFetchFromRemote,
                state.value.nowPlayingPage).collect{result->
                _state.update { it.copy(isLoading = true) }
                    when(result){
                        is Resource.Success -> {
                            result.data?.let { nowPlaying ->
                                _state.update {
                                    it.copy(
                                        isLoading = false,
                                        nowPlayingMovies = nowPlaying,
                                        nowPlayingPage = it.nowPlayingPage + 1
                                    )
                                }}

                        }
                        is Resource.Error ->{
                            _state.update { it.copy(
                                isLoading = false
                                , error = result.message
                            )

                            }
                        }
                        is Resource.Loading -> {
                            _state.update { it.copy(isLoading = true) }
                        }

                    }
            }
        }
    }


    private fun getPopularMovieList(forceFetchFromRemote: Boolean) {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            repository.getMovies(
                forceFetchFromRemote,
                Category.POPULAR,
                state.value.popularPage
            ).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.update {
                            it.copy(isLoading = false)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { popularList ->
                            _state.update {
                                it.copy(
                                    popularMovies = state.value.popularMovies
                                            + popularList.shuffled(),
                                    popularPage = state.value.popularPage + 1
                                )
                            }
                        }
                    }

                    is Resource.Loading -> {
                        _state.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }
                }
            }
        }
    }

    private fun getUpcomingMovieList(forceFetchFromRemote: Boolean) {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            repository.getMovies(
                forceFetchFromRemote,
                Category.UPCOMING,
                state.value.upComingPage
            ).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.update {
                            it.copy(isLoading = false)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { upcomingList ->
                            _state.update {
                                it.copy(
                                    upComingMovies = state.value.upComingMovies
                                            + upcomingList.shuffled(),
                                    upComingPage = state.value.upComingPage + 1
                                )
                            }
                        }
                    }

                    is Resource.Loading -> {
                        _state.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }
                }
            }
        }
    }



}