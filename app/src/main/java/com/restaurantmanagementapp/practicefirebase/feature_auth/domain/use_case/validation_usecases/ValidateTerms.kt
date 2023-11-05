package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases

class ValidateTerms {

    fun execute(acceptedTerms: Boolean): ValidationResult {
        if (!acceptedTerms) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Please accept the terms",
            )
        }
        return ValidationResult(
            isSuccessful = true,
        )
    }
}
