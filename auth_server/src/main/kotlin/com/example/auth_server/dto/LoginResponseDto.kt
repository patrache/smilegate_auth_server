package com.example.auth_server.dto

data class LoginResponseDto(
    var result: String,
    var email: String,
    var nickname: String
)
