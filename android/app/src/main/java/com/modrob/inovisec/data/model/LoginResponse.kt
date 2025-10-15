package com.modrob.inovisec.data.model

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val user: User? = null
)

data class User(
    val id: String,
    val email: String,
    val name: String
)