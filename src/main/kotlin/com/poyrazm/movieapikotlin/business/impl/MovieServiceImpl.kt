package com.poyrazm.movieapikotlin.business.impl

import com.poyrazm.movieapikotlin.dao.MovieRepository
import com.poyrazm.movieapikotlin.dto.MovieDTO
import com.poyrazm.movieapikotlin.dto.MovieRequest
import com.poyrazm.movieapikotlin.utils.mapper.MovieMapper
import org.springframework.stereotype.Service
import com.poyrazm.movieapikotlin.business.service.MovieService
import com.poyrazm.movieapikotlin.entity.Movie
import com.poyrazm.movieapikotlin.exception.enum.MovieExceptionTypes
import com.poyrazm.movieapikotlin.exception.exceptions.MoviesNotFoundException

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {

    //TODO("Will be added the all Exception Classes")
    //TODO("Will be added the Spring-Boot-Validation")
    //TODO("Will be added the Docker and Kubernetes integration")
    //TODO("Will be added the RabbitMQ Queue Messagging")
    //TODO("Will be added the Unit Test")


    override fun createMovie(req: MovieRequest): MovieDTO {
        val movieRequest = movieMapper.requestToEntity(req)
        movieRepository.save(movieRequest)
        return movieMapper.fromEntity(movieRequest)
    }

    override fun getAllMovies(): List<MovieDTO> {
        val moviesList = movieRepository.findAll().toList()
        return movieMapper.entityListToDtoList(moviesList)
    }

    override fun receiveMovieById(id : Long): MovieDTO {
        val movie = movieRepository.findById(id)
        return movieMapper.fromEntity(movie.get())
    }

    override fun updateMovieById(id: Long, req: MovieRequest): MovieDTO {
        val validMovie = movieRepository.findReferenceById(id)

        if (validMovie.isPresent) {
            val updatedMovie = validMovie.get()
            movieMapper.updateReqToMovie(req, updatedMovie)
            movieRepository.save(updatedMovie)
            return movieMapper.fromEntity(updatedMovie)
        } else throw MoviesNotFoundException(MovieExceptionTypes.MOVIES_NOT_FOUND_EXCEPTION.getValue())
    }

    override fun deleteMovieById(id: Long): String {
        val movie = movieRepository.findById(id)

        if (movie.isPresent) {
            movieRepository.delete(movie.get())
            return "Movie was deleted successfully"
        } else throw RuntimeException("Hata")

    }
}
