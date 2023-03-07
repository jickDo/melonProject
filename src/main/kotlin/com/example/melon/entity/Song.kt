package com.example.melon.entity

import org.hibernate.annotations.Formula
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany


@Entity
class Song(
    val title:String,
    val genre:String,
    val release_date:String,
    val lyrics:String,
    val play_time:String,
    val composer:String,

    @ManyToOne
    @JoinColumn(name="albumId")
    var album:Album,

    @ManyToOne
    @JoinColumn(name = "artistId")
    val artist: Artist,



) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val songId:Long=0L

    @Formula("(select count(*) from good g, song s where g.song_id = s.song_id)")
    val goodCount:Int = 0
}