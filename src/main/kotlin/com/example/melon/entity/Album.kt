package com.example.melon.entity

import javax.persistence.*

@Entity
class Album(
    val title:String,
    val release_date:String,
    val genre:String,

    @ManyToOne
    @JoinColumn(name="artist_id")
    var artist:Artist,

    @OneToMany(mappedBy = "album")
    val song: List<Song> = arrayListOf()
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val albumId:Long=0L



}