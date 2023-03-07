package com.example.melon.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Artist(
    val artistName:String,
    val debut_date:String,
    val agency:String,

    @OneToMany(mappedBy = "artist")
    val song: List<Song> = arrayListOf()

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val artistId:Long=0L
}