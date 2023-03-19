package com.movieapptask.domain.repository

import com.movieapptask.app.utils.Constants
import com.movieapptask.data.ApiInterface
import com.movieapptask.domain.model.request.AddRemoveFavouriteBody
import com.movieapptask.domain.model.response.FavouriteStatusModel
import com.movieapptask.domain.model.response.GenresModel
import com.movieapptask.domain.model.response.MoviesModel
import com.movieapptask.domain.model.response.StatusResponse
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.*
import javax.inject.Inject

@ViewModelScoped
class MoviesRepo @Inject constructor(private val service: ApiInterface) {
    suspend fun getCategories(): Flow<ApiResult<List<GenresModel.Genre>>> = flow {
        emit(ApiResult.Loading)
        try {
            val response = service.getCategories(Locale.getDefault().language)
            emit(ApiResult.Success(response.genres))
        } catch (e: IOException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: HttpException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        }
    }

    suspend fun getMoviesByCategory(genreId: Int): Flow<ApiResult<List<MoviesModel.Movie>>> =
        flow {
            emit(ApiResult.Loading)
            try {
                val response = service.getMoviesByCategory(Locale.getDefault().language, 1, genreId)
                emit(ApiResult.Success(response.results))
            } catch (e: IOException) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            } catch (e: HttpException) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            } catch (e: Exception) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            }
        }

    suspend fun search(query: String): Flow<ApiResult<List<MoviesModel.Movie>>> =
        flow {
            emit(ApiResult.Loading)
            try {
                val response = service.search(Locale.getDefault().language, query)
                emit(ApiResult.Success(response.results))
            } catch (e: IOException) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            } catch (e: HttpException) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            } catch (e: Exception) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            }
        }

    suspend fun getFavourites(): Flow<ApiResult<List<MoviesModel.Movie>>> =
        flow {
            emit(ApiResult.Loading)
            try {
                val response = service.getFavourites(
                    Constants.account_id.toInt(),
                    Locale.getDefault().language,
                    Constants.session_id
                )
                emit(ApiResult.Success(response.results))
            } catch (e: IOException) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            } catch (e: HttpException) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            } catch (e: Exception) {
                emit(ApiResult.Error(e.localizedMessage.orEmpty()))
            }
        }

    suspend fun getMovieDetails(movie_id: Int): Flow<ApiResult<MoviesModel.Movie>> = flow {
        emit(ApiResult.Loading)
        try {
            val response = service.getMovieDetails(movie_id, Locale.getDefault().language)
            emit(ApiResult.Success(response))
        } catch (e: IOException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: HttpException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        }
    }

    suspend fun getFavouriteStatus(movie_id: Int): Flow<ApiResult<FavouriteStatusModel>> = flow {
        emit(ApiResult.Loading)
        try {
            val response = service.getFavouriteStatus(
                movie_id,
                Locale.getDefault().language,
                Constants.session_id
            )
            emit(ApiResult.Success(response))
        } catch (e: IOException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: HttpException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        }
    }

    suspend fun addRemoveFavourite(
        addRemoveFavouriteBody: AddRemoveFavouriteBody
    ): Flow<ApiResult<StatusResponse>> = flow {
        emit(ApiResult.Loading)
        try {
            val response = service.add_removeFavourite(
                Constants.account_id.toInt(),
                Locale.getDefault().language,
                Constants.session_id,
                addRemoveFavouriteBody
            )
            emit(ApiResult.Success(response))
        } catch (e: IOException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: HttpException) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage.orEmpty()))
        }
    }
}

sealed class ApiResult<out T> {
    object Loading : ApiResult<Nothing>()
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val message: String) : ApiResult<Nothing>()
}