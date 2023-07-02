package com.poyrazm.movieapikotlin.utils.mapper

import com.poyrazm.movieapikotlin.dto.MovieRequest

interface Mapper<D, E, R> {
    fun fromEntity(entity: E): D
    fun toEntity(dto: D): E
    fun requestToEntity(req : R) : E
    fun entityListToDtoList(entity: List<E>) : List<D>
    fun updateReqToMovie(req : MovieRequest, entity : E)
}