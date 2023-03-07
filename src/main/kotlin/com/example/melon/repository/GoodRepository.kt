package com.example.melon.repository

import com.example.melon.entity.Good
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GoodRepository : JpaRepository<Good, Long>
