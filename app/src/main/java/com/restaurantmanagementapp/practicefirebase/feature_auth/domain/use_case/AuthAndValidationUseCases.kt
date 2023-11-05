package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case

import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.auth_usecases.SignInUseCase
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.auth_usecases.SignUpUseCase
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidateEmail
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidatePassword
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidateRepeatedPassword
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidateTerms

data class AuthAndValidationUseCases(
    val SignInUseCase: SignInUseCase,
    val SignUpUseCase: SignUpUseCase,
    val ValidateEmailUseCase: ValidateEmail,
    val ValidatePasswordUseCase: ValidatePassword,
    val ValidateRepeatedPasswordUseCase: ValidateRepeatedPassword,
    val ValidateTermsUseCase: ValidateTerms,

)
