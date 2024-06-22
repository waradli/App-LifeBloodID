package com.example.appslifebloodid.ui.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appslifebloodid.data.repository.AuthRepository
import com.example.appslifebloodid.data.response.AuthResponse
import com.example.appslifebloodid.data.response.LoginRequest
import com.example.appslifebloodid.data.response.RegisterRequest
import kotlinx.coroutines.launch

class AuthViewModel(application: Application, private val repository: AuthRepository) : AndroidViewModel(application) {
    private val _loginResult = MutableLiveData<AuthResponse?>()
    val loginResult: MutableLiveData<AuthResponse?> get() = _loginResult

    private val _registerResult = MutableLiveData<AuthResponse?>()
    val registerResult: MutableLiveData<AuthResponse?> get() = _registerResult

    private val _logoutStatus = MutableLiveData<Boolean>()
    val logoutStatus: LiveData<Boolean> get() = _logoutStatus

    private val preferences: SharedPreferences = application.getSharedPreferences("auth", Context.MODE_PRIVATE)

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = repository.login(LoginRequest(username, password))
            _loginResult.postValue(response)
            response?.token?.let { token ->
                saveToken(token)
                saveUsername(username)
            }
        }
    }

    fun register(username: String, email: String, password: String) {
        viewModelScope.launch {
            val response = repository.register(RegisterRequest(username, email, password))
            _registerResult.postValue(response)
            response?.token?.let { token ->
                saveToken(token)
                saveUsername(username)
            }
        }
    }

    private fun saveToken(token: String) {
        preferences.edit().putString("auth_token", token).apply()
    }

    fun getToken(): String? {
        return preferences.getString("auth_token", null)
    }

    fun clearToken() {
        preferences.edit().remove("auth_token").apply()
    }

    fun isUserLoggedIn(): Boolean {
        return getToken() != null
    }

    fun getUsername(): String? {
        return preferences.getString("auth_username", null)
    }

    private fun saveUsername(username: String) {
        preferences.edit().putString("auth_username", username).apply()
    }

    fun clearUsername() {
        preferences.edit().remove("auth_username").apply()
    }

    fun logout() {
        clearToken()
        clearUsername()
        _logoutStatus.postValue(true)
    }
}