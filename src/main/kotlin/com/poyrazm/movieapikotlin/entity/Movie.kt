package com.poyrazm.movieapikotlin.entity

import jakarta.persistence.*

@Entity
@Table(name = "movie")
data class Movie (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var name: String,
    var rating: Double
)
