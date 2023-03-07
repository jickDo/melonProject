package com.example.melon.controller

import com.example.melon.dto.AlbumDto
import com.example.melon.dto.ArtistDto
import com.example.melon.entity.Artist
import com.example.melon.entity.User
import com.example.melon.service.ArtistService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/artist")
class ArtistController(
    private val artistService: ArtistService
) {
    @PostMapping("")
    fun addArtist(@RequestBody artistDto: ArtistDto): ResponseEntity<Artist>{
        return ResponseEntity.ok(this.artistService.addArtist(artistDto))
    }

    @GetMapping(path = ["/{artistId}"])
    fun getArtist(@PathVariable("artistId") artistId:Long):ArtistDto{
        return artistService.getArtist(artistId)
    }
}