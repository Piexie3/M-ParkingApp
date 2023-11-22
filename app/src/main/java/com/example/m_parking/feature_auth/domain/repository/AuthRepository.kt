package com.daematech.m_parking.feature_auth.domain.repository

import com.daematech.m_parking.core.utils.Resource
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Resource<FirebaseUser>?
    suspend fun signup(email: String, password: String, userName: String): Resource<FirebaseUser>?
    suspend fun logout()
}