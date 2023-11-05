package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.models

data class AuthenticationResult(
    val isSuccessful: Boolean = false,
    val errorMessage: String? = null,
)
