package com.restaurantmanagementapp.practicefirebase.feature_auth.domain.repository

import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.models.AuthenticationResult
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.models.UserAuthenticationModel
import com.restaurantmanagementapp.practicefirebase.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun logInUser(user: UserAuthenticationModel): Flow<Resource<AuthenticationResult>>
    fun singUpUser(user: UserAuthenticationModel): Flow<Resource<AuthenticationResult>>

    fun logOut()
}
