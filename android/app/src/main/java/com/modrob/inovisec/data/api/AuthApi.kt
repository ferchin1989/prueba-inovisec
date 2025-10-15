package com.modrob.inovisec.data.api

import com.modrob.inovisec.data.model.LoginRequest
import com.modrob.inovisec.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}