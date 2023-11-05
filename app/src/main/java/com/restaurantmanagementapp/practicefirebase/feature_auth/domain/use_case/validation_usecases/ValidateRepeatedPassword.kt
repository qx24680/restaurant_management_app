package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases

class ValidateRepeatedPassword {

    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if (password != repeatedPassword) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The passwords don't match",
            )
        }
        return ValidationResult(
            isSuccessful = true,
        )
    }
}
