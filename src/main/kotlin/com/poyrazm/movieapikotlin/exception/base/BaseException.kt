package com.poyrazm.movieapikotlin.exception.base

open class BaseException(override val message: String) : RuntimeException(message)