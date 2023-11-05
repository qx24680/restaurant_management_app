package com.restaurantmanagementapp.practicefirebase.di

import com.google.firebase.auth.FirebaseAuth
import com.restaurantmanagementapp.practicefirebase.feature_auth.data.repository.AuthRepositoryImpl
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.repository.AuthRepository
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.AuthAndValidationUseCases
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.auth_usecases.SignInUseCase
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.auth_usecases.SignUpUseCase
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidateEmail
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidatePassword
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidateRepeatedPassword
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.validation_usecases.ValidateTerms
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun AuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun AuthAndValidationUseCase(repository: AuthRepository): AuthAndValidationUseCases {
        return AuthAndValidationUseCases(
            SignInUseCase = SignInUseCase(repository),
            SignUpUseCase = SignUpUseCase(repository),
            ValidateEmailUseCase = ValidateEmail(),
            ValidatePasswordUseCase = ValidatePassword(),
            ValidateRepeatedPasswordUseCase = ValidateRepeatedPassword(),
            ValidateTermsUseCase = ValidateTerms(),

        )
    }
}
