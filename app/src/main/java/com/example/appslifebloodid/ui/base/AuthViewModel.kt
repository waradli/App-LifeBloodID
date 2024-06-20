package com.example.appslifebloodid.ui.base

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appslifebloodid.data.repository.AuthRepository
import com.example.appslifebloodid.data.response.AuthResponse
import com.example.appslifebloodid.data.response.LoginRequest
import com.example.appslifebloodid.data.response.RegisterRequest
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<AuthResponse>()
    val loginResult: LiveData<AuthResponse> get() = _loginResult

    private val _registerResult = MutableLiveData<AuthResponse>()
    val registerResult: LiveData<AuthResponse> get() = _registerResult

    @SuppressLint("NullSafeMutableLiveData")
    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = repository.login(LoginRequest(username, password))
            _loginResult.postValue(response)
        }
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun register(username: String, email: String, password: String) {
        viewModelScope.launch {
            val response = repository.register(RegisterRequest(username, email, password))
            _registerResult.postValue(response)
        }
    }
}