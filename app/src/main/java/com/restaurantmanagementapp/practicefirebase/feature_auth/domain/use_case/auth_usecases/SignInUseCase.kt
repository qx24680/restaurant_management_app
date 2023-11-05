package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.auth_usecases

import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.models.UserAuthenticationModel
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.repository.AuthRepository
import com.restaurantmanagementapp.practicefirebase.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SignInUseCase(
    private val repository: AuthRepository
) {

    operator fun invoke(user: UserAuthenticationModel): Flow<Resource<UserAuthenticationModel>> = flow{
        repository.logInUser(user)
    }
}