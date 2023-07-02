package com.poyrazm.movieapikotlin.exception.exceptions

import com.poyrazm.movieapikotlin.exception.base.BaseException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MovieNotCreatedException(override val message: String) : BaseException(message) {

    private val LOG : Logger = LoggerFactory.getLogger(MovieNotCreatedException::class.java)
    init {
        LOG.info("[MoviesNotCreatedException] -> message : {}", message)
    }
}