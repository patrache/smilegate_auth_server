package com.example.auth_server.security

import org.springframework.stereotype.Component
import java.security.MessageDigest

@Component
class PasswordEncoder {

    fun encoder(input: String): String {
        val bytes = input.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }

    fun matches(stored: String, input: String):String {
        return if (stored == input){
            "success"
        } else {
            "failed"
        }
    }
}