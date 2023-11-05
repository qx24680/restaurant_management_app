package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if(password.length < 8) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage  = "The password needs to consist of at least 8 characters"
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if(!containsLettersAndDigits) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}