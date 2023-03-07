package com.example.melon.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity
class Good(

    @ManyToOne
    @JoinColumn(name="song_id")
    var song: Song,

    @ManyToOne
    @JoinColumn(name="user")
    var user:User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val goodId:Long=0L
}