package com.example.melon.repository

import com.example.melon.entity.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface AlbumRepository:JpaRepository<Album,Long> {
}