package com.example.auth_server.dto

data class SignupRequestDto(
    val email:String,
    val password: String,
    val nickname: String
)