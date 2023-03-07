package com.example.melon.controller

import com.example.melon.dto.SongDto
import com.example.melon.service.SongService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/song")
class SongController(
    private val songService: SongService,
) {
    @PostMapping(path = ["/{userId}/{userId2}"])
    fun addSong(@RequestBody songDto: SongDto, @PathVariable("userId") userId: Long, @PathVariable("userId2") userId2: Long): ResponseEntity<Boolean> {
        return ResponseEntity.ok(songService.addSong(songDto, userId, userId2))
    }

    @GetMapping(path = ["/{songId}"])
    fun getSong(@PathVariable("songId") songId: Long): ResponseEntity<SongDto> {
        return ResponseEntity.ok(songService.getSong(songId))
    }
}
