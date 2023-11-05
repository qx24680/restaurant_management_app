package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: String? = null,
)
