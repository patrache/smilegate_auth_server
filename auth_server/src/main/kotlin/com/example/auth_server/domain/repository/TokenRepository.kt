package com.example.auth_server.domain.repository

import com.example.auth_server.domain.entity.Token
import org.springframework.data.jpa.repository.JpaRepository

interface TokenRepository:JpaRepository<Token, Long> {
    fun findTokenByUserEmail(userEmail: String): Token?
    fun deleteTokenByUserEmail(userEmail: String)
}