package com.example.auth_server.security

import com.example.auth_server.domain.entity.Token
import com.example.auth_server.domain.repository.TokenRepository
import com.example.auth_server.dto.EmailDto
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TokenService(
    val tokenRepository: TokenRepository
) {
    /*
    * 로그인이 성공하면 토큰을 생성해줘야함.
    * 로그인이 되어 있어야 접근 가능한 공간에 check 해준다.
    * 활동이 있을 때마다 토큰을 업데이트 해준다.
    * 토큰이 기간이 만료됬을 때 없애준다.
    * */
    fun createToken(userEmail: String): String{
        tokenRepository.findTokenByUserEmail(userEmail)
            ?.let { return "이미 로그인 되있음" }

         val token = Token(
             userEmail = userEmail,
             createdAt = LocalDateTime.now(),
             updatedAt = LocalDateTime.now()
         )

        tokenRepository.save(token)
        return "token successfully created"
    }

    fun updateToken(userEmail: EmailDto){
        val token = tokenRepository.findTokenByUserEmail(userEmail.email)
            ?.let {
                it.updatedAt = LocalDateTime.now()
            }
        tokenRepository.flush()
    }

    fun deleteToken(userEmail: EmailDto){
        val token = tokenRepository.findTokenByUserEmail(userEmail.email)
        if(token != null){
            tokenRepository.delete(token)
        }
    }

    fun checkToken(userEmail: EmailDto):String{
        val token = tokenRepository.findTokenByUserEmail(userEmail.email)
            ?.let {
                return "authorized"
            }
        return "unauthorized"
    }
}