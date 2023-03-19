package com.movieapptask.domain.model.request

data class AddRemoveFavouriteBody(
    val favorite: Boolean=false,
    val media_id: Int=0,
    val media_type: String=""
)