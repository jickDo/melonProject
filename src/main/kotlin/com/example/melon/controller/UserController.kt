package com.example.melon.controller

import com.example.melon.dto.UserDto
import com.example.melon.entity.User
import com.example.melon.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("")
    fun register(@RequestBody userDto: UserDto): ResponseEntity<User> {
        return ResponseEntity.ok(this.userService.register(userDto))
    }

    @GetMapping("")
    fun login(@RequestBody userDto: UserDto): ResponseEntity<String> {
        return ResponseEntity.ok(this.userService.signin(userDto))
    }
}
