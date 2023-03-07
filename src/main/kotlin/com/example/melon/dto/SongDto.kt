package com.example.melon.dto

import com.example.melon.entity.Album
import com.example.melon.entity.Artist
import com.example.melon.entity.Song

data class SongDto(
    val title:String,
    val genre:String,
    val release_date:String,
    val lyrics:String,
    val play_time:String,
    val composer:String,
    )
{
    var albumTitle: String? = null
    var albumRelease:String? = null
    var albumGenre:String? = null
    var artistName:String?=null
    var artistDebute:String?= null
    var artistAgency:String?= null
    var goodCount:Int? = null
    companion object{
        fun toSongDto(song: Song):SongDto{
            return SongDto(
                song.title,
                song.genre,
                song.release_date,
                song.lyrics,
                song.play_time,
                song.composer,
            ).also {
                it.albumTitle = song.album.title
                it.albumRelease= song.album.release_date
                it.albumGenre= song.album.genre
                it.artistName=song.artist.artistName
                it.artistDebute=song.artist.debut_date
                it.artistAgency=song.artist.agency
                it.goodCount = song.goodCount
            }
        }
         fun toSong(songDto: SongDto,album: Album,artist:Artist,):Song {
             return Song(
                 songDto.title,
                 songDto.genre,
                 songDto.release_date,
                 songDto.lyrics,
                 songDto.play_time,
                 songDto.composer,
                 album,
                 artist
             )
         }
            }
}
