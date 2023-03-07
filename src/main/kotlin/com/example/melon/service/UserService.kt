package com.example.melon.service

import com.example.melon.dto.UserDto
import com.example.melon.entity.User
import com.example.melon.repository.UserRepository
import com.example.melon.security.JwtUtils
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtUtils: JwtUtils,
    private val authenticationManager: AuthenticationManager,

) {

    fun register(userDto: UserDto): User {
        return userRepository.save(userDto.toUser())
    }

    @Transactional(readOnly = true)
    fun signin(userDto: UserDto): String {
        try {
            // 인증시도
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(userDto.userId, userDto.password, null),
            )
        } catch (e: BadCredentialsException) {
            throw BadCredentialsException("로그인 실패")
        }
        // 예외가 발생하지 않았다면 인증에 성공한 것.
        // 토큰 생성
        val token = jwtUtils.createToken(userDto.userId)
        return token
    }
}
