package com.example.melon.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Genre(
    val genreName:String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val genreId:Long=0L
}