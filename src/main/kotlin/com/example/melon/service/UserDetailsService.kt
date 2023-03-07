package com.example.melon.service

import com.example.melon.entity.User
import com.example.melon.repository.UserRepository
import com.example.melon.security.UserDetailsImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername( userid: String): UserDetails {
        val user:User = userRepository.findByuserId(userid.toLong()) ?: throw UsernameNotFoundException("존재하지 않는 username 입니다.")

        return UserDetailsImpl(user)
    }
}