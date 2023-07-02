package com.poyrazm.movieapikotlin.dto

import java.time.LocalDateTime

data class MovieExceptionResponse(
    var status : String,
    var timeStamp: LocalDateTime,
    var message : String?,
    var statusCode : Int
)
