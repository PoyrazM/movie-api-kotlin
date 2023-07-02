package com.poyrazm.movieapikotlin.exception.enum

enum class MovieExceptionTypes(private val value: String) : IMovieExceptionTypes {

    MOVIES_NOT_CREATED_EXCEPTION("Movie Not Created !"),
    MOVIES_NOT_FOUND_EXCEPTION("Not Found Any Movies !"),
    MOVIE_NOT_FOUND_EXCEPTION("Movie Not Found With This Movie ID"),
    MOVIE_NOT_UPDATED_EXCEPTION("Movie Not Updated With This Movie ID"),
    MOVIE_NOT_DELETED_EXCEPTIPN("Movie Not Deleted With This Movie ID");

    override fun getValue(): String {
        return this.value
    }
}