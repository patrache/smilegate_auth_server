package com.example.auth_server.domain.repository

import com.example.auth_server.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findUserByEmail(email: String):User?

}