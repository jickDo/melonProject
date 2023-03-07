package com.example.melon.service

import com.example.melon.dto.AlbumDto
import com.example.melon.repository.AlbumRepository
import com.example.melon.repository.ArtistRepository
import org.springframework.stereotype.Service

@Service
class AlbumService(
    private val albumRepository: AlbumRepository,
    private val artistRepository: ArtistRepository,
) {
    fun addAlbum(albumDto: AlbumDto, userId: Long): AlbumDto {
        val album = albumRepository.save(AlbumDto.toAlbum(albumDto, artistRepository.findById(userId).orElse(null)))
        return AlbumDto.toAlbumDto(album)
    }

    fun getAlbum(albumId: Long): AlbumDto {
        return AlbumDto.toAlbumDto(albumRepository.getReferenceById(albumId))
    }
}
