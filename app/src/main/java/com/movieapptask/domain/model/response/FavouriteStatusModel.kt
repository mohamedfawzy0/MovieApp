package com.movieapptask.domain.model.response

data class FavouriteStatusModel(
    var favorite: Boolean = false,
    var id: Int = 0,
    var rated: Boolean = false,
    var watchlist: Boolean = false
)