package com.example.melon.dto

import com.example.melon.entity.User

data class UserDto(
    val name: String,
    val email: String,
    val password: String,
    val createdDate: String,
    var userId: Long,
) {

    fun toUser(): User {
        return User(
            name,
            email,
            createdDate,
        ).also {
            it.password = password
            it.userId = userId
        }
    }
    companion object {
        fun toUserDto(user: User): UserDto {
            return UserDto(
                user.name,
                user.email,
                user.password,
                user.created_date,
                user.userId,
            )
        }
    }
}
