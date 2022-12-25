package com.example.auth_server.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
data class Token (
    @Id
    @GeneratedValue
    var id : Long? = null,

    @Column
    var userEmail : String,

    @Column
    @CreatedDate
    var createdAt: LocalDateTime?,

    @Column
    @LastModifiedDate
    var updatedAt:LocalDateTime?
)