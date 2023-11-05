package com.restaurantmanagementapp.practicefirebase.feature_auth.presentation.signup_screen

data class SignUpScreenState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: String? = null,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null,
    val isLoading:Boolean = false,
    val signUpError: String? = null

)
