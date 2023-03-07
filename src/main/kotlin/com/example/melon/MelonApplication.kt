package com.example.melon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MelonApplication

fun main(args: Array<String>) {
    runApplication<MelonApplication>(*args)
}
