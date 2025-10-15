package com.modrob.inovisec.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modrob.inovisec.data.model.LoginResponse
import com.modrob.inovisec.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val user: LoginResponse) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel : ViewModel() {
    private val authRepository = AuthRepository()
    
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    
    private val _emailError = MutableStateFlow<String?>(null)
    val emailError: StateFlow<String?> = _emailError.asStateFlow()
    
    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError: StateFlow<String?> = _passwordError.asStateFlow()
    
    fun validateEmail(email: String): Boolean {
        return if (email.isEmpty()) {
            _emailError.value = "El correo electrónico es obligatorio"
            false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailError.value = "Formato de correo electrónico inválido"
            false
        } else {
            _emailError.value = null
            true
        }
    }
    
    fun validatePassword(password: String): Boolean {
        return if (password.isEmpty()) {
            _passwordError.value = "La contraseña es obligatoria"
            false
        } else if (password.length < 6) {
            _passwordError.value = "La contraseña debe tener al menos 6 caracteres"
            false
        } else {
            _passwordError.value = null
            true
        }
    }
    
    fun login(email: String, password: String) {
        val isEmailValid = validateEmail(email)
        val isPasswordValid = validatePassword(password)
        
        if (!isEmailValid || !isPasswordValid) {
            return
        }
        
        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading
            
            authRepository.login(email, password).fold(
                onSuccess = { response ->
                    if (response.success) {
                        _uiState.value = LoginUiState.Success(response)
                    } else {
                        _uiState.value = LoginUiState.Error(response.message)
                    }
                },
                onFailure = { exception ->
                    _uiState.value = LoginUiState.Error(exception.message ?: "Error desconocido")
                }
            )
        }
    }
    
    fun resetState() {
        _uiState.value = LoginUiState.Idle
    }
}