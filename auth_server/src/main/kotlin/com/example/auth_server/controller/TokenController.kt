package com.example.auth_server.controller

import com.example.auth_server.dto.EmailDto
import com.example.auth_server.security.TokenService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/token")
class TokenController(
    val tokenService: TokenService
) {

    @PostMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    fun checkToken(@RequestBody emailDto: EmailDto):String{
        return tokenService.checkToken(emailDto)
    }

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun refreshToken(){
        TODO()
    }

    @PostMapping("/delete/")
    @ResponseStatus(HttpStatus.OK)
    fun deleteToken(@RequestBody emailDto: EmailDto){
        tokenService.deleteToken(emailDto)
    }
}