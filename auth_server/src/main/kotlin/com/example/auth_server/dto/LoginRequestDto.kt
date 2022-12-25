package com.example.auth_server.dto

data class LoginRequestDto (
    val email:String,
    val password: String,
)