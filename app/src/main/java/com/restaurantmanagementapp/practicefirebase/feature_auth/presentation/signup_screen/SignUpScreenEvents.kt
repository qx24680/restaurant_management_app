package com.restaurantmanagementapp.practicefirebase.feature_auth.presentation.signup_screen

sealed class SignUpScreenEvents {
    data class EmailChanged(val email: String) : SignUpScreenEvents()
    data class PasswordChanged(val password: String) : SignUpScreenEvents()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : SignUpScreenEvents()
    data class AcceptTerms(val isAccepted: Boolean) : SignUpScreenEvents()

    object Sumbit : SignUpScreenEvents()
}
