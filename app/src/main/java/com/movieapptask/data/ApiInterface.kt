package com.movieapptask.data

import com.movieapptask.domain.model.request.AddRemoveFavouriteBody
import com.movieapptask.domain.model.response.FavouriteStatusModel
import com.movieapptask.domain.model.response.GenresModel
import com.movieapptask.domain.model.response.MoviesModel
import com.movieapptask.domain.model.response.StatusResponse
import retrofit2.http.*


interface ApiInterface {

    @GET("genre/movie/list")
    suspend fun getCategories(
        @Query("language") language: String
    ): GenresModel

    @GET("movie/popular")
    suspend fun getMoviesByCategory(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("with_genres") with_genres: Int,
    ): MoviesModel

    @GET("search/movie")
    suspend fun search(
        @Query("language") language: String,
        @Query("query") query: String
    ): MoviesModel

    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavourites(
        @Path("account_id") account_id: Int,
        @Query("language") language: String,
        @Query("session_id") session_id: String,
    ): MoviesModel

    @GET("movie/{movie_id}/account_states")
    suspend fun getFavouriteStatus(
        @Path("movie_id") movie_id: Int,
        @Query("language") language: String,
        @Query("session_id") session_id: String
    ): FavouriteStatusModel

    @POST("account/{account_id}/favorite")
    suspend fun add_removeFavourite(
        @Path("account_id") account_id: Int,
        @Query("language") language: String,
        @Query("session_id") session_id: String,
        @Body addRemoveFavouriteBody: AddRemoveFavouriteBody
    ): StatusResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id: Int,
        @Query("language") language: String,
    ): MoviesModel.Movie
}
