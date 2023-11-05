package com.restaurantmanagementapp.practicefirebase.feature_auth.presentation.signup_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.models.UserAuthenticationModel
import com.restaurantmanagementapp.practicefirebase.feature_auth.domain.use_case.AuthAndValidationUseCases
import com.restaurantmanagementapp.practicefirebase.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpScreenViewModel @Inject constructor(
    private val authAndValidationUseCases: AuthAndValidationUseCases,
) : ViewModel() {
    private val _signUpScreenState = MutableStateFlow(SignUpScreenState())
    val signUpScreenState = _signUpScreenState.asStateFlow()

    fun onEvent(event: SignUpScreenEvents) {
        when (event) {
            is SignUpScreenEvents.EmailChanged -> {
                _signUpScreenState.value = _signUpScreenState.value.copy(
                    email = event.email,
                )
            }

            is SignUpScreenEvents.PasswordChanged -> {
                _signUpScreenState.value = _signUpScreenState.value.copy(
                    password = event.password,
                )
            }
            is SignUpScreenEvents.RepeatedPasswordChanged -> {
                _signUpScreenState.value = _signUpScreenState.value.copy(
                    repeatedPassword = event.repeatedPassword,
                )
            }
            is SignUpScreenEvents.AcceptTerms -> {
                _signUpScreenState.value = _signUpScreenState.value.copy(
                    acceptedTerms = event.isAccepted,
                )
            }
            is SignUpScreenEvents.Sumbit -> {
                SubmitData()
            }
        }
    }

    fun SubmitData() {
        val emailResult = authAndValidationUseCases.ValidateEmailUseCase.execute(signUpScreenState.value.email)
        val passwordResult = authAndValidationUseCases.ValidatePasswordUseCase.execute(signUpScreenState.value.password)
        val repeatedPasswordResult = authAndValidationUseCases.ValidateRepeatedPasswordUseCase.execute(signUpScreenState.value.password, signUpScreenState.value.repeatedPassword)
        val termsResult = authAndValidationUseCases.ValidateTermsUseCase.execute(signUpScreenState.value.acceptedTerms)

        val isError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult,
        ).any { !it.isSuccessful }

        if (isError) {
            _signUpScreenState.value = signUpScreenState.value.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage,
            )
            return
        }

        authAndValidationUseCases.SignUpUseCase(
            UserAuthenticationModel(
                email =signUpScreenState.value.email,
            password = signUpScreenState.value.password)
        ).onEach {
              when(it){
                  is Resource.Loading->{
                      _signUpScreenState.value = signUpScreenState.value.copy(
                          isLoading = it.isLoading
                      )
                  }
                  is Resource.Error->{
                      _signUpScreenState.value = signUpScreenState.value.copy(
                          signUpError = it.message
                      )
                  }
                  is Resource.Success->{
                      print("registered")

                  }
              }
        }.launchIn(viewModelScope)

    }
}
