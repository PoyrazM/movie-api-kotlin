package com.poyrazm.movieapikotlin.controller

import com.poyrazm.movieapikotlin.business.service.MovieService
import com.poyrazm.movieapikotlin.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/movies")
class MovieController(private val movieService: MovieService) {

    @PostMapping
    fun createNewMovie(@RequestBody req: MovieRequest) : ResponseEntity<MovieDTO> {
        val savedMovie = movieService.createMovie(req)
        return ResponseEntity(savedMovie, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllMovies() : ResponseEntity<List<MovieDTO>> {
        val allMovies = movieService.getAllMovies()
        return ResponseEntity.ok(allMovies)
    }

    @GetMapping("/{movieId}")
    fun receiveMovieById(@PathVariable movieId : Long) : ResponseEntity<MovieDTO> {
        val movie = movieService.receiveMovieById(movieId)
        return ResponseEntity.ok(movie)
    }

    @PutMapping("/{movieId}")
    fun updateMovieById(@PathVariable movieId: Long,
                        @RequestBody req: MovieRequest) : ResponseEntity<MovieDTO> {
        val movie = movieService.updateMovieById(movieId, req)
        return ResponseEntity.ok(movie)
    }

    @DeleteMapping("/{movieId}")
    fun deleteMovieById(@PathVariable movieId: Long) {
        movieService.deleteMovieById(movieId)
    }
}



