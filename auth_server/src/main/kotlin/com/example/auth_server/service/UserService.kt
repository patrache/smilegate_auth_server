package com.example.auth_server.service

import com.example.auth_server.domain.entity.User
import com.example.auth_server.domain.repository.UserRepository
import com.example.auth_server.dto.LoginRequestDto
import com.example.auth_server.dto.LoginResponseDto
import com.example.auth_server.dto.SignupRequestDto
import com.example.auth_server.dto.UserResponseDto
import com.example.auth_server.security.PasswordEncoder
import com.example.auth_server.security.TokenService
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import kotlin.math.log

@Service
@Transactional
class UserService(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder,
    val tokenService: TokenService
) {

    val logger = KotlinLogging.logger {  }

    fun signUp(signupRequestDto: SignupRequestDto):String{
        var result:String = "success"

        userRepository.findUserByEmail(signupRequestDto.email)
            ?.let {
                result = "failed"
            }

        if(result == "failed") return result

        val user = User(
            email = signupRequestDto.email,
            password = passwordEncoder.encoder(signupRequestDto.password),
            nickname = signupRequestDto.nickname
        )

        logger.info { "result is  $result" }
        userRepository.save(user)
        return result
    }

    fun login(loginRequestDto: LoginRequestDto):LoginResponseDto{
        var result:LoginResponseDto = LoginResponseDto(
            result = "no user",
            email = "",
            nickname = ""
        )
        val inputPassword = passwordEncoder.encoder(loginRequestDto.password)
        userRepository.findUserByEmail(loginRequestDto.email)
            ?.let {
                result.result = passwordEncoder.matches(it.password , inputPassword)
                result.email = it.email
                result.nickname = it.nickname
            }
        tokenService.createToken(loginRequestDto.email)
        return result
    }

    fun getAllUser(): List<UserResponseDto>{
        val userResponseList:MutableList<UserResponseDto> = mutableListOf()

        userRepository.findAll().forEach {
            userResponseList.add(
                UserResponseDto(it.id!!, it.nickname)
            )
        }

        return userResponseList
    }
}