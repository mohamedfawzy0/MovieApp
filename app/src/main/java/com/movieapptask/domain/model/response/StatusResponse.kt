package com.movieapptask.domain.model.response

data class StatusResponse(
    var status_code: Int = 0,
    var status_message: String = "",
    var success: Boolean = false
)