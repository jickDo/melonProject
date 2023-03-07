package com.example.melon.service

import com.example.melon.dto.SongDto
import com.example.melon.repository.AlbumRepository
import com.example.melon.repository.ArtistRepository
import com.example.melon.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(
    private val songRepository: SongRepository,
    private val artistRepository: ArtistRepository,
    private val albumRepository: AlbumRepository,

) {
    fun addSong(songDto: SongDto, userId: Long, userId2: Long): Boolean {
        songRepository.save(
            SongDto.toSong(
                songDto,
                albumRepository.findById(userId).orElse(null),
                artistRepository.findById(userId2).orElse(null),
            ),
        )
        return true
    }

    fun getSong(songId: Long): SongDto {
        return SongDto.toSongDto(songRepository.findById(songId).orElse(null))
    }
}
