package com.example.auth_server.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="users")
data class User(
    @Id
    @GeneratedValue
    var id : Long? = null,

    @Column
    var email : String,

    @Column
    var password : String,

    @Column
    var nickname : String
)