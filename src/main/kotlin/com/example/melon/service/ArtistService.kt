package com.example.melon.service

import com.example.melon.dto.ArtistDto
import com.example.melon.entity.Artist
import com.example.melon.repository.ArtistRepository
import org.springframework.stereotype.Service

@Service
class ArtistService(
    private val artistRepository: ArtistRepository,
) {
    fun addArtist(artistDto: ArtistDto): Artist {
        return artistRepository.save(ArtistDto.toArtist(artistDto))
    }
    fun getArtist(artistId: Long): ArtistDto {
        return ArtistDto.toArtistDto(artistRepository.findById(artistId).orElse(null))
    }
}
