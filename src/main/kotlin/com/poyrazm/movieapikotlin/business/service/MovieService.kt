package com.poyrazm.movieapikotlin.business.service

import com.poyrazm.movieapikotlin.dto.*

interface MovieService {
    fun createMovie(req: MovieRequest) : MovieDTO
    fun getAllMovies() : List<MovieDTO>
    fun receiveMovieById(id : Long) : MovieDTO
    fun updateMovieById(id: Long, req: MovieRequest) : MovieDTO
    fun deleteMovieById(id : Long) : String
}