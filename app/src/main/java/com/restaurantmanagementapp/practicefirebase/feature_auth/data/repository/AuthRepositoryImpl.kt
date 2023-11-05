package com.restaurantmanagementapp.practicefirebase.feature_auth.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.models.AuthenticationResult
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.models.UserAuthenticationModel
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.repository.AuthRepository
import com.restaurantmanagementapp.practicefirebase.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : AuthRepository {
    override  fun logInUser(user: UserAuthenticationModel): Flow<Resource<AuthenticationResult>> = flow {

    }

    override  fun singUpUser(user: UserAuthenticationModel): Flow<Resource<AuthenticationResult>> = flow {

        try {
            emit(Resource.Loading<AuthenticationResult>(isLoading = true))
            val signedUpUser = firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).await()
            emit(
                Resource.Success<AuthenticationResult>(
                    AuthenticationResult(
                        isSuccessful = true,
                    ),
                ),
            )
        } catch (e: IOException) {
            emit(Resource.Loading<AuthenticationResult>(isLoading = false))
            emit(Resource.Error<AuthenticationResult>(message = "Check your Internet Connection"))
        } catch (e: Exception) {
            emit(Resource.Loading<AuthenticationResult>(isLoading = false))
            emit(Resource.Error<AuthenticationResult>(message = "An unexpected error occured"))
        }
    }

    override fun logOut() {
    }
}
