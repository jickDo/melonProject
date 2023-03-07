package com.example.melon.repository

import com.example.melon.entity.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface SongRepository:JpaRepository<Song,Long> {
}