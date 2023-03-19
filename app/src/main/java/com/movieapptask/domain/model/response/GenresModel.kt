package com.movieapptask.domain.model.response

data class GenresModel(
    var genres: ArrayList<Genre> = ArrayList()
) {
    data class Genre(
        var id: Int = 0,
        var name: String = "",
        var isSelected:Boolean = false
    )
}