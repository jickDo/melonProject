package com.example.melon.repository

import com.example.melon.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User,Long> {
    fun findByuserId(userId:Long):User
}