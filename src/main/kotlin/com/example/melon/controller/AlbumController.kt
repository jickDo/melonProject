package com.example.melon.controller

import com.example.melon.dto.AlbumDto
import com.example.melon.entity.Album
import com.example.melon.service.AlbumService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/album")

class AlbumController(
    private val albumService: AlbumService
) {
    @PostMapping(path=["/{userId}"])
    fun addAlbum(@RequestBody albumDto: AlbumDto,@PathVariable("userId") userId:Long):ResponseEntity<AlbumDto>{
        return ResponseEntity.ok(albumService.addAlbum(albumDto,userId))
    }

    @GetMapping("{albumId}")
    fun getAlbum(@PathVariable(name = "albumId") albumId:Long): AlbumDto {
        return albumService.getAlbum(albumId)
    }

}