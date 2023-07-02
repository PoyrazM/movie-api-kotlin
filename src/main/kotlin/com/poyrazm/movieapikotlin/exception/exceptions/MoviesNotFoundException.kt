package com.poyrazm.movieapikotlin.exception.exceptions

import com.poyrazm.movieapikotlin.exception.base.BaseException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MoviesNotFoundException(message: String) : BaseException(message) {

    private val LOG : Logger = LoggerFactory.getLogger(MovieNotCreatedException::class.java)

    init {
        LOG.info("[MoviesNotFoundException] -> message : {}", message)
    }
}