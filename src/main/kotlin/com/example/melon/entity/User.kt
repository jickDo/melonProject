package com.example.melon.entity

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
class User(
    val name:String,

    @Column(unique = true)
    val email:String,

    val created_date:String,


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId:Long=0L

    @Column
    var password=""
        get()=field
        set(value){
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password:String):Boolean{
        return BCryptPasswordEncoder().matches(password,this.password)
    }
}