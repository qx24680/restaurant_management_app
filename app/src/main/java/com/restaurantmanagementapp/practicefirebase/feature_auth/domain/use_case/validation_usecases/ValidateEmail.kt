package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases

import android.util.Patterns

class ValidateEmail {
    fun execute(email: String): ValidationResult {
        if (email.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The email can't be blank",
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "That's not a valid email",
            )
        }
        return ValidationResult(isSuccessful = true)
    }
}
