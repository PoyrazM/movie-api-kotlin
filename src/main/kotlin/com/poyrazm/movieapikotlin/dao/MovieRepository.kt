package com.poyrazm.movieapikotlin.dao

import com.poyrazm.movieapikotlin.entity.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MovieRepository : CrudRepository<Movie, Long> {
    fun findReferenceById(id : Long) : Optional<Movie>
}