package com.movieapptask.app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapptask.domain.model.request.AddRemoveFavouriteBody
import com.movieapptask.domain.model.response.GenresModel
import com.movieapptask.domain.model.response.MoviesModel
import com.movieapptask.domain.repository.ApiResult
import com.movieapptask.domain.repository.MoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repo: MoviesRepo) : ViewModel() {

    private var _isLoadingLivData: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoadingLivData

    private val _categoriesLiveData: MutableLiveData<List<GenresModel.Genre>> = MutableLiveData()
    val categoriesLiveData: LiveData<List<GenresModel.Genre>> = _categoriesLiveData

    private val _moviesLiveData: MutableLiveData<List<MoviesModel.Movie>> = MutableLiveData()
    val moviesLiveData: LiveData<List<MoviesModel.Movie>> = _moviesLiveData

    private val _movieDetailsLiveData: MutableLiveData<MoviesModel.Movie> = MutableLiveData()
    val movieDetailsLiveData: LiveData<MoviesModel.Movie> = _movieDetailsLiveData

    private var _isFavouriteLivData: MutableLiveData<Boolean> = MutableLiveData(true)
    val isFavouriteLivData: LiveData<Boolean> = _isFavouriteLivData

    private var _addRemoveFavouriteLivData: MutableLiveData<String> = MutableLiveData("")
    val addRemoveFavouriteLivData: LiveData<String> = _addRemoveFavouriteLivData

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    fun getCategories() {
        viewModelScope.launch {
            repo.getCategories()
                .flowOn(Dispatchers.IO)
                .onEach {
                    when (it) {
                        is ApiResult.Error -> {
                            _isLoadingLivData.value = false
                            _errorMessage.value = it.message
                        }
                        ApiResult.Loading -> {
                            _isLoadingLivData.value = true
                        }
                        is ApiResult.Success -> {
                            _isLoadingLivData.value = false
                            _categoriesLiveData.value = it.data!!
                        }
                    }
                }.collect()
        }
    }
    fun getMoviesByCategory(genreId: Int) {
        viewModelScope.launch {
            repo.getMoviesByCategory(genreId)
                .flowOn(Dispatchers.IO)
                .onEach {
                    when (it) {
                        is ApiResult.Error -> {
                            _isLoadingLivData.value = false
                            _errorMessage.value = it.message
                        }
                        ApiResult.Loading -> {
                            _isLoadingLivData.value = true
                        }
                        is ApiResult.Success -> {
                            _isLoadingLivData.value = false
                            _moviesLiveData.value = it.data!!
                        }
                    }
                }.collect()
        }
    }
    fun search(query: String) {
        viewModelScope.launch {
            repo.search(query)
                .flowOn(Dispatchers.IO)
                .onEach {
                    when (it) {
                        is ApiResult.Error -> {
                            _isLoadingLivData.value = false
                            _errorMessage.value = it.message
                        }
                        ApiResult.Loading -> {
                            _isLoadingLivData.value = true
                        }
                        is ApiResult.Success -> {
                            _isLoadingLivData.value = false
                            _moviesLiveData.value = it.data!!
                        }
                    }
                }.collect()
        }
    }
    fun getFavourites() {
        viewModelScope.launch {
            repo.getFavourites()
                .flowOn(Dispatchers.IO)
                .onEach {
                    when (it) {
                        is ApiResult.Error -> {
                            _isLoadingLivData.value = false
                            _errorMessage.value = it.message
                        }
                        ApiResult.Loading -> {
                            _isLoadingLivData.value = true
                        }
                        is ApiResult.Success -> {
                            _isLoadingLivData.value = false
                            _moviesLiveData.value = it.data!!
                        }
                    }
                }.collect()
        }
    }

    fun getMovieDetails(movie_id: Int) {
        viewModelScope.launch {
            repo.getMovieDetails(movie_id)
                .flowOn(Dispatchers.IO)
                .onEach {
                    when (it) {
                        is ApiResult.Error -> {
                            _isLoadingLivData.value = false
                            _errorMessage.value = it.message
                        }
                        ApiResult.Loading -> {
                            _isLoadingLivData.value = true
                        }
                        is ApiResult.Success -> {
                            _isLoadingLivData.value = false
                            _movieDetailsLiveData.value = it.data!!
                        }
                    }
                }.collect()
        }
    }
    fun getFavouriteStatus(movie_id: Int) {
        viewModelScope.launch {
            repo.getFavouriteStatus(movie_id)
                .flowOn(Dispatchers.IO)
                .onEach {
                    when (it) {
                        is ApiResult.Error -> {
                            _isLoadingLivData.value = false
                            _errorMessage.value = it.message
                        }
                        ApiResult.Loading -> {
                            _isLoadingLivData.value = true
                        }
                        is ApiResult.Success -> {
                            _isLoadingLivData.value = false
                            _isFavouriteLivData.value = it.data.favorite!!
                        }
                    }
                }.collect()
        }
    }
    fun addRemoveFavourite(addRemoveFavouriteBody: AddRemoveFavouriteBody) {
        viewModelScope.launch {
            repo.addRemoveFavourite(addRemoveFavouriteBody)
                .flowOn(Dispatchers.IO)
                .onEach {
                    when (it) {
                        is ApiResult.Error -> {
                            _isLoadingLivData.value = false
                            _errorMessage.value = it.message
                        }
                        ApiResult.Loading -> {
                            _isLoadingLivData.value = true
                        }
                        is ApiResult.Success -> {
                            _isLoadingLivData.value = false
                            _addRemoveFavouriteLivData.value = it.data.status_message!!
                        }
                    }
                }.collect()
        }
    }

}
