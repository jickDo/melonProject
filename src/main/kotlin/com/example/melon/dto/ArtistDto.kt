package com.example.melon.dto

import com.example.melon.entity.Album
import com.example.melon.entity.Artist

data class ArtistDto(
    val artistName:String,
    val debut_date:String,
    val agency:String,
    val artistList: List<SongDto>?
)
{
    companion object{
        fun toArtistDto(artist: Artist):ArtistDto{
            return ArtistDto(
                artist.artistName,
                artist.debut_date,
                artist.agency,
                artist.song.map {
                    SongDto.toSongDto(it)
                }
            )
        }
        fun toArtist(artistDto: ArtistDto): Artist {
            return Artist(
                artistDto.artistName,
                artistDto.debut_date,
                artistDto.agency
            )
        }
    }}