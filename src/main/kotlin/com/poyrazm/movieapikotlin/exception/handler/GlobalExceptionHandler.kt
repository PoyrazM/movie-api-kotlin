package com.poyrazm.movieapikotlin.exception.handler

import com.poyrazm.movieapikotlin.dto.MovieExceptionResponse
import com.poyrazm.movieapikotlin.exception.enum.MovieExceptionTypes
import com.poyrazm.movieapikotlin.exception.exceptions.MovieNotCreatedException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler{

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleGeneralException(exception: Exception) : MovieExceptionResponse {
        return movieExceptionResponseParser(
            LocalDateTime.now(),
            exception.message,
            HttpStatus.BAD_REQUEST.value()
        )
    }

    private fun movieExceptionResponseParser(
        localDateTime: LocalDateTime,
        message: String?,
        statusCode: Int
    ): MovieExceptionResponse {
        return MovieExceptionResponse("failed", localDateTime, message, statusCode)
    }
}