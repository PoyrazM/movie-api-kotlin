package com.poyrazm.movieapikotlin.utils.mapper

import com.poyrazm.movieapikotlin.dto.MovieDTO
import com.poyrazm.movieapikotlin.dto.MovieRequest
import com.poyrazm.movieapikotlin.entity.Movie
import org.springframework.stereotype.Component

@Component
class MovieMapper: Mapper<MovieDTO, Movie, MovieRequest> {
    override fun fromEntity(entity: Movie): MovieDTO {
        return MovieDTO(
            entity.id,
            entity.name,
            entity.rating
        )
    }

    override fun toEntity(dto: MovieDTO): Movie {
        return Movie(
            dto.id,
            dto.name,
            dto.rating
        )
    }

    override fun requestToEntity(req: MovieRequest): Movie {
        return Movie(
            null,
            req.name,
            req.rating
        )
    }

    override fun entityListToDtoList(entity: List<Movie>): List<MovieDTO> {
        return entity.map {
            fromEntity(it)
        }
    }

    override fun updateReqToMovie(req: MovieRequest, entity: Movie) {
        entity.name = req.name
        entity.rating = req.rating
    }
}