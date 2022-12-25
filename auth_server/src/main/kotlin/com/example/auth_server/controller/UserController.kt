package com.example.auth_server.controller

import com.example.auth_server.domain.entity.User
import com.example.auth_server.dto.LoginRequestDto
import com.example.auth_server.dto.LoginResponseDto
import com.example.auth_server.dto.SignupRequestDto
import com.example.auth_server.dto.UserResponseDto
import com.example.auth_server.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
){
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    fun signup(@RequestBody signupRequestDto: SignupRequestDto): String{
        return userService.signUp(signupRequestDto)
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody loginRequestDto: LoginRequestDto): LoginResponseDto{
        return userService.login(loginRequestDto)
    }

    @PostMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    fun getAllUser():List<UserResponseDto>{
        return userService.getAllUser()
    }
}