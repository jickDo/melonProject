package com.example.melon.dto

import com.example.melon.entity.Album
import com.example.melon.entity.Artist
import com.example.melon.entity.Song

data class AlbumDto(
    val title:String,
    val release_date:String,
    val genre:String,
    val songList: List<SongDto>?
    )
{
    companion object{
        fun toAlbumDto(album: Album):AlbumDto{
            return AlbumDto(
                album.title,
                album.release_date,
                album.genre,
                album.song.map{
                    SongDto.toSongDto(it)
                }
        )
    }
        fun toAlbum(albumDto: AlbumDto,artist:Artist): Album {
            return Album(
                albumDto.title,
                albumDto.release_date,
                albumDto.genre,
                artist
                )
        }

    }}